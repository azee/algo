import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Created by azee on 22.12.14.
 */
public class Main {
    public static void main(String... args) {
        for (CacheName cacheName : CacheName.values()){
            System.out.println(cacheName.value());
        }
    }

    public enum CacheName {

        @XmlEnumValue("configCache")
        CONFIG_CACHE("configCache"),
        @XmlEnumValue("userCache")
        USER_CACHE("userCache"),
        @XmlEnumValue("packCache")
        PACK_CACHE("packCache");
        private final String value;

        CacheName(String v) {
            value = v;
        }

        public String value() {
            return value;
        }

        public static CacheName fromValue(String v) {
            for (CacheName c: CacheName.values()) {
                if (c.value.equals(v)) {
                    return c;
                }
            }
            throw new IllegalArgumentException(v);
        }

    }



}
