package labs.command_pattern;

import labs.command_pattern.Fan.Fan;
import labs.command_pattern.Light.Light;
import labs.command_pattern.Light.LightOffCommand;
import labs.command_pattern.Light.LightOnCommand;
import labs.command_pattern.TV.TV;
import labs.command_pattern.TV.TVOffCommand;
import labs.command_pattern.TV.TVOnCommand;
import labs.command_pattern.TV.TVVolumeDownCommand;
import labs.command_pattern.TV.TVVolumeUpCommand;
import labs.command_pattern.Fan.FanOnCommand;
import labs.command_pattern.Fan.FanOffCommand;

public class Client {
    public static void main(String[] args) {
        Light livingRoomLight = new Light("Living Room Light");
        Light kitchenRoomLight = new Light("Kitchen Room Light");
        TV livingRoomTV = new TV("Living Room TV");
        Fan bedroomFan = new Fan("Bedroom Fan", 0);

        RemoteControl remoteControl = new RemoteControl();

        Command noCommand = new NoCommand();
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenRoomLightOn = new LightOnCommand(kitchenRoomLight);
        LightOffCommand kitchenRoomLightOff = new LightOffCommand(kitchenRoomLight);
        TVOnCommand livingRoomTVOn = new TVOnCommand(livingRoomTV);
        TVOffCommand livingRoomTVOff = new TVOffCommand(livingRoomTV);
        TVVolumeUpCommand livingRoomTVUp = new TVVolumeUpCommand(livingRoomTV);
        TVVolumeDownCommand livingRoomTVDown = new TVVolumeDownCommand(livingRoomTV);
        FanOnCommand bedroomFanOn = new FanOnCommand(bedroomFan);
        FanOffCommand bedroomFanOff = new FanOffCommand(bedroomFan);

        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff, noCommand, noCommand);
        remoteControl.setCommand(1, kitchenRoomLightOn, kitchenRoomLightOff, noCommand, noCommand);
        remoteControl.setCommand(2, livingRoomTVOn, livingRoomTVOff, livingRoomTVUp, livingRoomTVDown);
        remoteControl.setCommand(3, bedroomFanOn, bedroomFanOff, noCommand, noCommand);

        System.out.println(remoteControl);

        remoteControl.onButton(0);
        remoteControl.offButton(0);
        remoteControl.onButton(1);
        remoteControl.offButton(1);
        remoteControl.onButton(2);
        remoteControl.offButton(2);
        remoteControl.volumeUpButton(2);
        remoteControl.volumeDownButton(2);
        remoteControl.onButton(3);
        remoteControl.onButton(3);
        remoteControl.onButton(3);
        remoteControl.onButton(3);
        remoteControl.offButton(3);
        remoteControl.undoButton();
        remoteControl.undoButton();
    }
}