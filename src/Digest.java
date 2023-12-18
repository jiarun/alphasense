import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;

public abstract class Digest {
    private Map<byte[], byte[]> cache = new HashMap<byte[], byte[]>();

    public byte[] digest(byte[] input) {
        byte[] result = cache.get(input);
        if (result == null) {
            synchronized (cache) {
                result = cache.get(input);
                if (result == null) {
                    try {
                        result = doDigest(input);
                        cache.put(input, result);
                    } catch (RuntimeException ex) {
                        LoggerFactory.getLogger("Digest").error(
                                "Unable to make digest"
                        );
                        throw ex;
                    }
                }
            }
        }
        return result;
    }

    protected abstract byte[] doDigest(byte[] input);
}