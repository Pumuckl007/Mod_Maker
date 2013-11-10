package modmaker.gui;

import java.awt.Canvas;

public interface GLTask {
	public GLThreadRecall getReCall();
	public Object[] runTask(Canvas c);
}
