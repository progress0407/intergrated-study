package designpattern.proxy;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class YalcoProxyMain {

	public static void main(String[] args) {
		List<Thumbnail> proxyThumbnails = new ArrayList<>();

		proxyThumbnails.add(new ProxyThumbnail("/movie?name=darknight", "배트맨 다크나이트"));
		proxyThumbnails.add(new ProxyThumbnail("/movie?name=sen-chihiro", "센과 치히로의 행방불명"));
		proxyThumbnails.add(new ProxyThumbnail("/movie?name=home-alone", "나 홀로 집에"));
		proxyThumbnails.add(new ProxyThumbnail("/movie?name=new-world", "신세계"));
		proxyThumbnails.add(new ProxyThumbnail("/movie?name=gurren-lagann", "천원돌파 그렌라간"));

		proxyThumbnails.stream().iterator().forEachRemaining(thumbnail -> thumbnail.showTitle());

		System.out.println("___________________________________________________");

		proxyThumbnails.stream().iterator().forEachRemaining(thumbnail -> thumbnail.showPreview());
	}

	private interface Thumbnail {
		void showTitle();
		void showPreview();
	}

	private static class ProxyThumbnail implements Thumbnail {

		private String movieUrl;
		private String title;
		private RealThumbnail realThumbnail;

		public ProxyThumbnail(String movieUrl, String title) {
			this.movieUrl = movieUrl;
			this.title = title;
		}

		@Override
		public void showTitle() {
			System.out.printf("제목은 \"%s\" 입니다\n", title);
		}

		@Override
		public void showPreview() {
			if (realThumbnail == null) {
				realThumbnail = new RealThumbnail(movieUrl, title);
			}
			realThumbnail.showPreview();
		}
	}

	@AllArgsConstructor
	private static class RealThumbnail implements Thumbnail {

		private String movieUrl;
		private String title;

		@Override
		public void showTitle() {
			System.out.printf("\"%s\"의 제목은 \"%s\" 입니다\n", movieUrl, title);
		}

		@Override
		public void showPreview() {
			System.out.println("기다리는 중입니다 ...");
			sleep();
			System.out.printf("\"%s\"로부터 \"%s\"를 다운받았습니다\n프리뷰 재생중..", movieUrl, title);
		}

		private void sleep() {
			try {
				Thread.sleep(500L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}