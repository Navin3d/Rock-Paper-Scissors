package gmc.project.practice.rockpaperscissors.exceptions;

public class RoomNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1685160022238725646L;

	public RoomNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public RoomNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public RoomNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public RoomNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public RoomNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
