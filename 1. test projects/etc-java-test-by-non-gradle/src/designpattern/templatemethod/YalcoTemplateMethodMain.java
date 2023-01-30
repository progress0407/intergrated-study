package designpattern.templatemethod;

public class YalcoTemplateMethodMain {

	public static void main(String[] args) {
		new NaverMapView().initMap();
		new KakaoMapview().initMap();
	}

	private interface MapView {

		void connectMapServer();
		 void showMapOnScreen();
		 void moveToCurrentLocation();

		default void initMap() {
			connectMapServer();
			showMapOnScreen();
			moveToCurrentLocation();
		}
	}

	private static class NaverMapView implements MapView {
		public void connectMapServer() {
			System.out.println("네이버 지도 서버에 연결");
		}


		public void showMapOnScreen() {
			System.out.println("네이버 지도를 보여줌");
		}

		public void moveToCurrentLocation() {
			System.out.println("네이버 지도에서 현재 좌표로 이동");
		}
	}

	private static class KakaoMapview implements MapView {
		public void connectMapServer() {
			System.out.println("카카오 지도 서버에 연결");
		}

		public void showMapOnScreen() {
			System.out.println("카카오 지도를 보여줌");
		}

		public void moveToCurrentLocation() {
			System.out.println("카카오 지도에서 현재 좌표로 이동");
		}
	}

}
