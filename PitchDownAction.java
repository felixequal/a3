package a3;

import sage.input.action.*;
import net.java.games.input.Event;
import sage.camera.*;
import graphicslib3D.Vector3D;
import graphicslib3D.Matrix3D;

public class PitchDownAction extends AbstractInputAction
{
	private ICamera camera;
	private SpaceShip ship;
	
	public PitchDownAction(ICamera c, SpaceShip ship)
	{
		this.camera = c;
		this.ship = ship;
	}

	@Override
	public void performAction(float time, Event e)
	{
		Matrix3D rotationAmt = new Matrix3D();
		
		Vector3D viewDir = camera.getViewDirection();
		Vector3D upDir = camera.getUpAxis();
		Vector3D rightDir = camera.getRightAxis();
		
		rotationAmt.rotate(-0.05, rightDir);
			
		viewDir = viewDir.mult(rotationAmt);
		upDir = upDir.mult(rotationAmt);
		
		camera.setUpAxis(upDir.normalize());
		camera.setViewDirection(viewDir.normalize());
		ship.setCamera(camera);
	}
}
