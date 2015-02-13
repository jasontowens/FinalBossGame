package map;

public class MotionValidator {
	private static MotionValidator validator = null;
	public static MotionValidator getInstance() {
		if(validator == null) {
			validator = new MotionValidator();
		}
		return validator;
	}

	public boolean canTraverse(MotionType entityMotion, MotionType terrainMotion) {
		switch(entityMotion) {
			case GROUND:
				switch(terrainMotion) {
					case GROUND:
						return true;
					case WATER:
						return false;
					case UNATTAINABLE:
						return false;
				}

				return false;
			case WATER:
				switch(terrainMotion) {
					case GROUND:
						return false;
					case WATER:
						return true;
					case UNATTAINABLE:
						return false;
				}

				return false;
			case UNATTAINABLE:
				return false;
		}

		return false;
	}
}