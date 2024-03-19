package de.telran.deliveryproject.generator;

import lombok.RequiredArgsConstructor;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

@RequiredArgsConstructor
public class UuidTimeSequenceGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        long currTimeMillis = System.currentTimeMillis();
        UUID uuid = UUID.randomUUID();

        return concatInHexFormat(currTimeMillis, uuid);
    }

    private char[] concatInHexFormat(long currTimeMillis, UUID uuid) {
        String uuidStr = uuid.toString().replace("-", "");
        String millisHex = Long.toHexString(currTimeMillis);
        String sequenceHex = uuidStr.substring(0, 16);

        String concatenated = millisHex + sequenceHex;

        return concatenated.toCharArray();
    }
}
