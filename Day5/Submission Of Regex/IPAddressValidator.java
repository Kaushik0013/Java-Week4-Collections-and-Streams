public class IPAddressValidator {
    public static void main(String[] args) {
        String[] testIPs = {
            "192.168.1.1",
            "255.255.255.255",
            "256.100.50.25",
            "192.168.1",
            "192.168.1.abc",
            "01.02.03.04",
            "300.1.1.1"
        };

        for (String ip : testIPs) {
            System.out.println(ip + " => " + isValidIPv4(ip));
        }
    }

    public static boolean isValidIPv4(String ip) {
        String ipv4Regex =
            "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}" +
            "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";
        return ip.matches(ipv4Regex);
    }
}
