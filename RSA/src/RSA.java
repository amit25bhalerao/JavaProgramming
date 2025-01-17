import java.io.*;
import java.math.*;
import java.util.*;

public class RSA
{
    private BigInteger p, q, N, phi, e, d;
    private int bitLength = 1024;
    private Random r;

    public RSA()
    {
        r = new Random();
        p = BigInteger.probablePrime(bitLength, r);       // Extremely Large Prime Number P
        q = BigInteger.probablePrime(bitLength, r);       // Extremely Large Prime Number Q

        System.out.println("Prime Number P: " + p);
        System.out.println("Prime Number Q: " + q);

        N = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));          // ϕ(N) = (P-1)*(Q-1)

        e = BigInteger.probablePrime(bitLength/2, r);     // 1 < e < ϕ(N)
        while ((phi.gcd(e).compareTo(BigInteger.ONE) > 0) && (e.compareTo(phi) < 0))        // GCD(e, ϕ(N)) = 1
        {
            e.add(BigInteger.ONE);
        }

        System.out.println("Public Key: " + e);

        d = e.modInverse(phi);                              // d * e mod ϕ(N) = 1
        System.out.println("Private Key: " + d);
    }

    public RSA(BigInteger e, BigInteger d, BigInteger N)
    {
        this.e = e;
        this.d = d;
        this.N = N;
    }

    public static void main(String[] args)throws IOException
    {
        RSA rsa = new RSA();

        DataInputStream in = new DataInputStream(System.in);

        String testString;
        System.out.println("Enter The Plain Text Below");
        testString = in.readLine();

        System.out.println("Encrypting String: " + testString);
        System.out.println("Encrypted String In Byte Format: " + bytesToString(testString.getBytes()));

        byte[] encrypted = rsa.encrypt(testString.getBytes());
        byte[] decrypted = rsa.decrypt(encrypted);

        System.out.println("Decrypted String In Byte Format: " + bytesToString(decrypted));
        System.out.println("Decrypted String: " + new String(decrypted));

    }
    public byte[] encrypt(byte[] message)
    {
        return  (new BigInteger(message)).modPow(e, N).toByteArray();
    }


    public byte[] decrypt(byte[] message)
    {
        return  (new BigInteger(message)).modPow(d, N).toByteArray();
    }

    private static String bytesToString(byte[] encrypted)
    {
        String test = "";
        for (byte b : encrypted)
        {
            test += Byte.toString(b);
        }
        return test;
    }
}
