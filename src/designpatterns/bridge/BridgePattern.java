package designpatterns.bridge;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-08-19
 * Time: 11:25
 */
public class BridgePattern {

    static abstract class SunGlasses {

        protected Style style;

        protected SunGlasses(Style style) {
            this.style = style;
        }

        abstract String getBrandName();

        public void putOn() {
            System.out.println("戴上" + getBrandName() + "-" + style.getStyle() + "风格的太阳镜");
        }

    }

    static class DiorSunGlasses extends SunGlasses {

        public DiorSunGlasses(Style style) {
            super(style);
        }

        @Override
        String getBrandName() {
            return "迪诺";
        }

    }

    interface Style {
        String getStyle();

    }

    static class RetroStyle implements Style {

        @Override
        public String getStyle() {
            return "复古";
        }
    }

    static class PilotStyle implements Style {

        @Override
        public String getStyle() {
            return "飞行员";
        }
    }
}
