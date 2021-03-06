package ru.narod.vn91.pointsop.utils;

import java.awt.*;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.prefs.Preferences;

public class Settings {

	private static boolean isDebug = false;
	private static String ircAddress = "pointsgame.net";

	static private final Set<Function<Void, Void>> colorChangeListenerList =
			new LinkedHashSet<>();

	static public final int newestVersion = 4;
	static final Preferences memory = Preferences.userRoot().node(
		"ru.narod.ru.pointsop.userdata");

	public static int getIrcPort() {
		return memory.getInt("ircPort", 6667);
	}

	public static void setIrcPort(int port) {
		memory.putInt("ircPort", port);
	}

	public static String getIrcAddress() {
		return ircAddress;
	}

	public static void setIrcAddress(String address) {
		Settings.ircAddress = address;
	}

	public static boolean isShowJoinPart() {
		return memory.getBoolean("isShowJoinPart", true);
	}

	public static void setShowJoinPart(boolean isShowJoinPart) {
		memory.putBoolean("isShowJoinPart", isShowJoinPart);
	}

	public static boolean isRestoreSize() {
		return memory.getBoolean("isRestoreSize", true);
	}

	public static void setRestoreSize(boolean isRestoreSize) {
		memory.putBoolean("isRestoreSize", isRestoreSize);
	}

	public static boolean isRestorePosition() {
		return memory.getBoolean("isRestorePosition", true);
	}

	public static void setRestorePosition(boolean isRestorePosition) {
		memory.putBoolean("isRestorePosition", isRestorePosition);
	}

	public static int getVersion() {
		return memory.getInt("version", newestVersion);
	}

	public static void setVersion(int ver) {
		memory.putInt("version", ver);
	}

	public static boolean isDebug() {
		return isDebug;
	}

	public static void setDebug(boolean isDebug) {
		Settings.isDebug = isDebug;
	}

//	public static boolean isZagramTest() {
//		return memory.getBoolean("isZagramTest", false);
//	}

//	public static void setZagramTest(boolean isZagramTest) {
//		memory.putBoolean("isZagramTest", isZagramTest);
//	}

	public static void setNewestVersion() {
		memory.putInt("version", newestVersion);
	}

	public static void setUserName(String newName) {
		memory.put("username", newName);
	}

	public static void setFrameWidth(int frameWidth) {
		memory.putInt("frameWidth", frameWidth);
	}

	public static void setFrameHeight(int frameHeight) {
		memory.putInt("frameHeight", frameHeight);
	}

	public static void setFrameX(int x) {
		memory.putInt("frameX", x);
	}

	public static void setFrameY(int y) {
		memory.putInt("frameY", y);
	}

	public static int getFrameWidth() {
		return memory.getInt("frameWidth", - 1);
	}

	public static int getFrameHeight() {
		return memory.getInt("frameHeight", - 1);
	}

	public static int getFrameX() {
		return memory.getInt("frameX", - 1);
	}

	public static int getFrameY() {
		return memory.getInt("frameY", - 1);
	}

	public static String getUserName() {
		return memory.get("username", "");
	}

	public static ClickAudibility getClickAudibility() {
		return ClickAudibility.valueOf_Failsafe(
				memory.get("ClickAudibility", ""));
	}

	public static boolean getOtherSounds() {
		return memory.getBoolean("OtherSounds", true);
	}

	public static void setOtherSounds(boolean otherSounds) {
		memory.putBoolean("OtherSounds", otherSounds);
	}

	public static void setClickAudibility(String s) {
		memory.put("ClickAudibility", ClickAudibility.valueOf_Failsafe(s).name());
	}

	public static void setKeijKvantttAiPath(String path) {
		memory.put("keijkvantttai", path);
	}

	public static String getKeijKvantttAiPath() {
		return memory.get("keijkvantttai", "");
	}

	private static double limitDotWidth(double d) {
		if (d > 1.0) {
			return 1.0;
		} else if (d < 0.1) {
			return 0.1;
		} else {
			return d;
		}
	}

	public static double getDotWidth() {
		try {
			String s = memory.get("DotWidth", "");
			return limitDotWidth(Double.parseDouble(s));
		} catch (Exception e) {
			return 0.5;
		}
	}

	public static void setDotWidth(double d) {
		d = limitDotWidth(d);
		memory.put("DotWidth", String.valueOf(d));
	}

	public static boolean getLastDotAnimation() {
		return memory.getBoolean("LastDotAnimation", false);
	}
	public static void setLastDotAnimation(boolean b) {
		memory.putBoolean("LastDotAnimation", b);
	}

	public static boolean getDrawConnections() {
		return memory.getBoolean("DrawConnections", true);
	}

	public static void setDrawConnections(boolean b) {
		memory.putBoolean("DrawConnections", b);
	}
	static final Color defaultColor1 = new Color(255, 0, 0);
	static final Color defaultColor2 = new Color(21, 96, 189);
	static final Color defaultColorBackground = new Color(255, 255, 255);

	public static Color getPlayer1Color() {
		int r = memory.getInt("1Red", defaultColor1.getRed());
		int g = memory.getInt("1Green", defaultColor1.getGreen());
		int b = memory.getInt("1Blue", defaultColor1.getBlue());
		return new Color(r, g, b);
	}

	public static Color getPlayer2Color() {
		int r = memory.getInt("2Red", defaultColor2.getRed());
		int g = memory.getInt("2Green", defaultColor2.getGreen());
		int b = memory.getInt("2Blue", defaultColor2.getBlue());
		return new Color(r, g, b);
	}

	public static Color getBackgroundColor() {
		int r = memory.getInt("BRed", defaultColorBackground.getRed());
		int g = memory.getInt("BGreen", defaultColorBackground.getGreen());
		int b = memory.getInt("BBlue", defaultColorBackground.getGreen());
		return new Color(r, g, b);
	}

	public static void setPlayer1Color(Color c, boolean notifyAll) {
		memory.putInt("1Red", c.getRed());
		memory.putInt("1Green", c.getGreen());
		memory.putInt("1Blue", c.getBlue());
		if (notifyAll) {
			notifyColorChange();
		}
	}

	public static void setPlayer2Color(Color c, boolean notifyAll) {
		memory.putInt("2Red", c.getRed());
		memory.putInt("2Green", c.getGreen());
		memory.putInt("2Blue", c.getBlue());
		if (notifyAll) {
			notifyColorChange();
		}
	}

	public static void setBackgroundColor(Color c, boolean notifyAll) {
		memory.putInt("BRed", c.getRed());
		memory.putInt("BGreen", c.getGreen());
		memory.putInt("BBlue", c.getBlue());
		if (notifyAll) {
			notifyColorChange();
		}
	}

	public static void resetColors() {
		setPlayer1Color(defaultColor1, false);
		setPlayer2Color(defaultColor2, false);
		setBackgroundColor(defaultColorBackground, false);
		notifyColorChange();
	}

	private static void notifyColorChange() {
		for (Function<Void, Void> listener : colorChangeListenerList) {
			try {
				listener.call(null);
			} catch (Exception ignored) {
			}
		}
	}

	public static void AddColorsChangeListener(Function<Void, Void> listener) {
		colorChangeListenerList.add(listener);
	}

	public enum ClickAudibility {

		IN_ALL_GAMES, IN_MY_GAMES, NOWHERE;

		public static ClickAudibility valueOf_Failsafe(String s) {
			try {
				return ClickAudibility.valueOf(s);
			} catch (Exception e) {
				return IN_MY_GAMES;
			}
		}
	}

}
