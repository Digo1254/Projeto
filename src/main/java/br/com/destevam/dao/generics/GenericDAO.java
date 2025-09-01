package main.java.br.com.destevam.dao.generics;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

import main.java.br.com.destevam.annotation.TipoChave;
import main.java.br.com.destevam.domain.Persistance;
import main.java.br.com.destevam.exception.TipoChaveNaoEncontradoException;

public abstract class GenericDAO<T extends Persistance> implements IGenericDAO<T> {

    private SingletonMap singletonMap;

    public abstract Class<T> getTipoClasse();

    public abstract void atualizarDados(T entidade, T entidadeCadastrado);

    public GenericDAO(){
        this.singletonMap =SingletonMap.getInstance();
    }

    public Long getChave(T entidade) throws TipoChaveNaoEncontradoException{
        Field[] fields = entidade.getClass().getDeclaredFields();
        Long returnValue = null;
        for(Field field : fields){
            if(field.isAnnotationPresent(TipoChave.class)){
                TipoChave tipoChave = field.getAnnotation(TipoChave.class);
                String nomeMetodo = tipoChave.value();
                try{
                    Method method = entidade.getClass().getMethod(nomeMetodo);
                    returnValue = (Long) method.invoke(entidade);
                    return returnValue;
                }catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
                    e.printStackTrace();
                    throw new TipoChaveNaoEncontradoException("Chave Principal do objeto" + entidade.getClass() + "");
                }
            }
        }

        if(returnValue == null){
            String msg = "Chave principal do obejto" + entidade.getClass() + "não encontrada";
            System.out.println("***** ERRO ******" + msg);
            throw new TipoChaveNaoEncontradoException(msg);
        }

        return null;
    }

    public Boolean cadastrar(T entidade) throws TipoChaveNaoEncontradoException{

        Map<Long, T> mapaInterno = (Map<Long,T>) this.singletonMap.getMap().get(getTipoClasse());
        Long chave = getChave(entidade);
        if(mapaInterno.containsKey(chave)){
            return false;
        }

        mapaInterno.put(chave, entidade);
        return true;

    }

    public void excluir(Long valor){
        Map<Long, T> mapaInterno = (Map<Long,T> ) this.singletonMap.getMap().get(getTipoClasse());
        T objetoCadastrado = mapaInterno.get(valor);
        if(objetoCadastrado != null){
            mapaInterno.remove(valor,objetoCadastrado);
        }
    }

    public void alterar(T entidade) throws TipoChaveNaoEncontradoException{
        Map<Long,T> mapaInterno = (Map<Long,T>) this.singletonMap.getMap().get(getTipoClasse());
        Long chave = getChave(entidade);
        T obejtoCadastrado = mapaInterno.get(chave);

        if(obejtoCadastrado !=null){
            atualizarDados(entidade, obejtoCadastrado);
        }

    }


    public T consultar(Long valor){
        Map<Long,T> mapaInterno = (Map<Long,T>) this.singletonMap.getMap().get(getTipoClasse());

        return mapaInterno.get(valor);
    }

    public Collection<T> buscarTodos(){
        Map<Long,T> mapaInterno = (Map<Long,T>) this.singletonMap.getMap().get(getTipoClasse());
        return mapaInterno.values();
    }
}
