import java.rmi.Naming;

/**
 * Клиент для удаленной службы которая умеет складывать числа
 */
public class SumClient {

    private final static String RMI_URL_TEMPLATE = "rmi://%s/SumServer";

    /**
     * Складывает два числа которые были переданы с консоли с помощью удаленной
     * процедуры
     *
     * @param args Аргументы с консоли
     */
    public static void main(String[] args) {
        try {
            final String remoteObjectUrl = String.format(RMI_URL_TEMPLATE, args[0]);
            SumService sumService = (SumService) Naming.lookup(remoteObjectUrl);

            final int a = Integer.valueOf(args[1]);
            final int b = Integer.valueOf(args[2]);

            System.out.printf("Первое число %d, второе число %d%n", a, b);

            int result = sumService.sum(a, b);

            System.out.printf("Результат удаленного суммирования %d%n", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
