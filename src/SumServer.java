import java.rmi.Naming;

/**
 * Сервер процедуры сложения
 */
public class SumServer {

    /**
     * Добавляет службу в реестр и делает ее доступной для вызова
     *
     * @param args Аргументы с консоли
     */
    public static void main(String[] args) {
        try {
            final SumService sumService = new SumImpl();
            Naming.rebind("SumServer", sumService);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
