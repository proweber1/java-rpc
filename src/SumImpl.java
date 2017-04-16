import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * RPC служба которая позволяет сложить два числа и вернуть их сумму клиенту
 */
public class SumImpl extends UnicastRemoteObject implements SumService {
    SumImpl() throws RemoteException {
    }

    @Override
    public int sum(int a, int b) throws RemoteException {
        return a + b;
    }
}
