package net.minecraft.network;

class TcpMasterThread extends Thread
{
    final TcpConnection field_74504_a;

    TcpMasterThread(TcpConnection p_i1395_1_)
    {
        this.field_74504_a = p_i1395_1_;
    }

    @SuppressWarnings("deprecation")
    public void run()
    {
        try
        {
            Thread.sleep(5000L);

            if (TcpConnection.func_74457_g(this.field_74504_a).isAlive())
            {
                try
                {
                    TcpConnection.func_74457_g(this.field_74504_a).stop();
                }
                catch (Throwable throwable)
                {
                    ;
                }
            }

            if (TcpConnection.func_74461_h(this.field_74504_a).isAlive())
            {
                try
                {
                    TcpConnection.func_74461_h(this.field_74504_a).stop();
                }
                catch (Throwable throwable1)
                {
                    ;
                }
            }
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
    }
}
