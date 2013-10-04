package net.minecraft.server.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

@SideOnly(Side.SERVER)
class TextAreaLogHandlerINNER1 extends Formatter
{
    final TextAreaLogHandler field_120031_a;

    TextAreaLogHandlerINNER1(TextAreaLogHandler p_i2370_1_)
    {
        this.field_120031_a = p_i2370_1_;
    }

    public String format(LogRecord p_format_1_)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(" [").append(p_format_1_.getLevel().getName()).append("] ");
        stringbuilder.append(this.formatMessage(p_format_1_));
        stringbuilder.append('\n');
        Throwable throwable = p_format_1_.getThrown();

        if (throwable != null)
        {
            StringWriter stringwriter = new StringWriter();
            throwable.printStackTrace(new PrintWriter(stringwriter));
            stringbuilder.append(stringwriter.toString());
        }

        return stringbuilder.toString();
    }
}
