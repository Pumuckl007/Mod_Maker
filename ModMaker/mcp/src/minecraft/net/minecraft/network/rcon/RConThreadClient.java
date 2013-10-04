package net.minecraft.network.rcon;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class RConThreadClient extends RConThreadBase
{
    private boolean field_72657_g;
    private Socket field_72659_h;
    private byte[] field_72660_i = new byte[1460];
    private String field_72658_j;

    RConThreadClient(IServer p_i1537_1_, Socket p_i1537_2_)
    {
        super(p_i1537_1_);
        this.field_72659_h = p_i1537_2_;

        try
        {
            this.field_72659_h.setSoTimeout(0);
        }
        catch (Exception var4)
        {
            this.field_72619_a = false;
        }

        this.field_72658_j = p_i1537_1_.func_71330_a("rcon.password", "");
        this.func_72609_b("Rcon connection from: " + p_i1537_2_.getInetAddress());
    }

    public void run()
    {
        try
        {
            while (true)
            {
                if (!this.field_72619_a)
                {
                    break;
                }

                BufferedInputStream bufferedinputstream = new BufferedInputStream(this.field_72659_h.getInputStream());
                int i = bufferedinputstream.read(this.field_72660_i, 0, 1460);

                if (10 <= i)
                {
                    byte b0 = 0;
                    int j = RConUtils.func_72665_b(this.field_72660_i, 0, i);

                    if (j != i - 4)
                    {
                        return;
                    }

                    int k = b0 + 4;
                    int l = RConUtils.func_72665_b(this.field_72660_i, k, i);
                    k += 4;
                    int i1 = RConUtils.func_72662_b(this.field_72660_i, k);
                    k += 4;

                    switch (i1)
                    {
                        case 2:
                            if (this.field_72657_g)
                            {
                                String s = RConUtils.func_72661_a(this.field_72660_i, k, i);

                                try
                                {
                                    this.func_72655_a(l, this.field_72617_b.func_71252_i(s));
                                }
                                catch (Exception exception)
                                {
                                    this.func_72655_a(l, "Error executing: " + s + " (" + exception.getMessage() + ")");
                                }

                                continue;
                            }

                            this.func_72656_f();
                            continue;
                        case 3:
                            String s1 = RConUtils.func_72661_a(this.field_72660_i, k, i);
                            int j1 = k + s1.length();

                            if (0 != s1.length() && s1.equals(this.field_72658_j))
                            {
                                this.field_72657_g = true;
                                this.func_72654_a(l, 2, "");
                                continue;
                            }

                            this.field_72657_g = false;
                            this.func_72656_f();
                            continue;
                        default:
                            this.func_72655_a(l, String.format("Unknown request %s", new Object[] {Integer.toHexString(i1)}));
                            continue;
                    }
                }
            }
        }
        catch (SocketTimeoutException sockettimeoutexception)
        {
        }
        catch (IOException ioexception)
        {
        }
        catch (Exception exception1)
        {
            System.out.println(exception1);
        }
        finally
        {
            this.func_72653_g();
        }
    }

    private void func_72654_a(int p_72654_1_, int p_72654_2_, String p_72654_3_) throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream(1248);
        DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
        byte[] abyte = p_72654_3_.getBytes("UTF-8");
        dataoutputstream.writeInt(Integer.reverseBytes(abyte.length + 10));
        dataoutputstream.writeInt(Integer.reverseBytes(p_72654_1_));
        dataoutputstream.writeInt(Integer.reverseBytes(p_72654_2_));
        dataoutputstream.write(abyte);
        dataoutputstream.write(0);
        dataoutputstream.write(0);
        this.field_72659_h.getOutputStream().write(bytearrayoutputstream.toByteArray());
    }

    private void func_72656_f() throws IOException
    {
        this.func_72654_a(-1, 2, "");
    }

    private void func_72655_a(int p_72655_1_, String p_72655_2_) throws IOException
    {
        int j = p_72655_2_.length();

        do
        {
            int k = 4096 <= j ? 4096 : j;
            this.func_72654_a(p_72655_1_, 0, p_72655_2_.substring(0, k));
            p_72655_2_ = p_72655_2_.substring(k);
            j = p_72655_2_.length();
        }
        while (0 != j);
    }

    private void func_72653_g()
    {
        if (null != this.field_72659_h)
        {
            try
            {
                this.field_72659_h.close();
            }
            catch (IOException ioexception)
            {
                this.func_72606_c("IO: " + ioexception.getMessage());
            }

            this.field_72659_h = null;
        }
    }
}
