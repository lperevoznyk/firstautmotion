package liseners;

import org.testng.IExecutionListener;

public class ExecutionListener implements IExecutionListener {

    @Override
    public void onExecutionStart() {
        IExecutionListener.super.onExecutionStart();
    }

    @Override
    public void onExecutionFinish() {
        IExecutionListener.super.onExecutionFinish();
    }
}