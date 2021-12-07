package designpattern.templatemethod;

public class YalcoTemplateMethodMain {

	public static void main(String[] args) {
		new NaverMapView().initMap();
		new KakaoMapview().initMap();
	}

	private static abstract class MapView {

		protected abstract void connectMapServer();
		protected abstract void showMapOnScreen();
		protected abstract void moveToCurrentLocation();

		public void initMap() {
			connectMapServer();
			showMapOnScreen();
			moveToCurrentLocation();
		}
	}

	private static class NaverMapView extends MapView {
		@Override
		protected void connectMapServer() {
			System.out.println("네이버 지도 서버에 연결");
		}

		@Override
		protected void showMapOnScreen() {
			System.out.println("네이버 지도를 보여줌");
		}

		@Override
		protected void moveToCurrentLocation() {
			System.out.println("네이버 지도에서 현재 좌표로 이동");
		}
	}

	private static class KakaoMapview extends MapView {
		@Override
		protected void connectMapServer() {
			System.out.println("카카오 지도 서버에 연결");
		}

		@Override
		protected void showMapOnScreen() {
			System.out.println("카카오 지도를 보여줌");
		}

		@Override
		protected void moveToCurrentLocation() {
			System.out.println("카카오 지도에서 현재 좌표로 이동");
		}
	}

}
