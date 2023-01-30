package designpattern.factorymethod;

public class YalcoFactoryMethod {
	private abstract class Component {
		abstract protected String getName();
		public Component() {
			System.out.println(this.getName() + " 생성");
		}
	}

	private class Button extends Component {
		@Override
		protected String getName() {
			return "버튼";
		}
	}

	private class Switch extends Component {
		@Override
		protected String getName() {
			return "스위치";
		}
	}

	private class Dropdown extends Component {
		@Override
		protected String getName() {
			return "드롭다운";
		}
	}

	private enum ComponentType {
		Button, Switch, Dropdown;
	}

	private class ComponentFactory {
		public Component create(ComponentType componentType) {
			switch (componentType) {
				case Button:
					return new Button();
				case Switch:
					return new Switch();
				case Dropdown:
					return new Dropdown();
			}
			return null;
		}
	}

	public static void main(String[] args) {
		ComponentFactory componentFactory = new YalcoFactoryMethod().new ComponentFactory();
		componentFactory.create(ComponentType.Button);
		componentFactory.create(ComponentType.Switch);
		componentFactory.create(ComponentType.Dropdown);
	}
}
