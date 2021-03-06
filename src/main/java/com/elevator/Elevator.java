package com.elevator;

import java.util.LinkedList;
import java.util.Queue;

import com.elevator.enums.ElevatorDirection;
import com.elevator.enums.ElevatorStatus;
import com.elevator.interfaces.ElevatorFactory;

/**
 * Created with IntelliJ IDEA.
 * User: josephblau
 * Date: 8/22/13
 * Time: 9:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class Elevator implements ElevatorFactory {
  private Integer currentFloor;
  private Queue<Integer> destinationFloors;

  public Elevator(Integer currentFloor) {
    this.currentFloor = currentFloor;
    this.destinationFloors = new LinkedList<Integer>();
  }

  public int nextDestionation(){
    return this.destinationFloors.peek();
  }

  public int currentFloor(){
    return this.currentFloor;
  }

  public void popDestination(){
    this.destinationFloors.remove();
  }
  @Override
  public void addNewDestinatoin(Integer destination) {
    this.destinationFloors.add(destination);
  }

  @Override
  public void moveUp() {
    currentFloor++;
  }

  @Override
  public void moveDown() {
    currentFloor--;
  }

  @Override
  public ElevatorDirection direction() {
    if (destinationFloors.size() > 0){
      if (currentFloor < destinationFloors.peek()) { //currentfloor = 3 & destinationFloor.peek(last added destination) = 7
        return ElevatorDirection.ELEVATOR_UP;
      } else if (currentFloor > destinationFloors.peek()) {
        return ElevatorDirection.ELEVATOR_DOWN;
      }
    }
    return ElevatorDirection.ELEVATOR_HOLD;
  }

  @Override
  public ElevatorStatus status() {
    return (destinationFloors.size() > 0)?ElevatorStatus.ELEVATOR_OCCUPIED:ElevatorStatus.ELEVATOR_EMPTY;
  }
}
