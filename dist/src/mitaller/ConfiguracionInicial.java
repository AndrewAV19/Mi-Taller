package mitaller;

import java.util.prefs.Preferences;

public class ConfiguracionInicial {
    private static final String PREF_APLICACION_ACTIVADA = "aplicacion_activada";

    public static void marcarAplicacionComoActivada() {
        Preferences prefs = Preferences.userNodeForPackage(ConfiguracionInicial.class);
        prefs.putBoolean(PREF_APLICACION_ACTIVADA, true);
    }

    public static boolean aplicacionYaActivada() {
        Preferences prefs = Preferences.userNodeForPackage(ConfiguracionInicial.class);
        return prefs.getBoolean(PREF_APLICACION_ACTIVADA, false);
    }
}