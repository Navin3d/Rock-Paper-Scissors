package gmc.project.practice.rockpaperscissors.exceptions;

public class PlayerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7089861796984965394L;

	public PlayerNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public PlayerNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PlayerNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public PlayerNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PlayerNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
