package fr.louarn.mescomptes.exeption;

public class DaoExeption extends Exception implements IExeption{
    @Override
    public void accept(IHandlerExeption handlerExeption) {
        handlerExeption.visite(this);
    }
}
