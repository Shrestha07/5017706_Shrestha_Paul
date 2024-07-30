import command.Light;
import command.LightOnCommand;
import command.LightOffCommand;
import command.RemoteControl;

public class CommandPatternTest {
    public static void main(String[] args) {
        // Create a receiver
        Light light = new Light();

        // Create commands
        LightOnCommand lightOn = new LightOnCommand(light);
        LightOffCommand lightOff = new LightOffCommand(light);

        // Create invoker
        RemoteControl remote = new RemoteControl();

        // Turn the light on
        remote.setCommand(lightOn);
        remote.pressButton();

        // Turn the light off
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}