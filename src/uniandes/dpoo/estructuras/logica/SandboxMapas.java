package uniandes.dpoo.estructuras.logica;

import java.util.*;

public class SandboxMapas {
    private Map<String, String> mapaCadenas;

    public SandboxMapas() {
        mapaCadenas = new HashMap<>();
    }

    public List<String> getValoresComoLista() {
        List<String> valores = new ArrayList<>(mapaCadenas.values());
        Collections.sort(valores);
        return valores;
    }

    public List<String> getLlavesComoListaInvertida() {
        List<String> llaves = new ArrayList<>(mapaCadenas.keySet());
        Collections.sort(llaves, Collections.reverseOrder());
        return llaves;
    }

    public String getPrimera() {
        if (mapaCadenas.isEmpty()) {
            return null;
        }
        List<String> llaves = new ArrayList<>(mapaCadenas.keySet());
        Collections.sort(llaves);
        return llaves.get(0);
    }

    public String getUltima() {
        if (mapaCadenas.isEmpty()) {
            return null;
        }
        List<String> valores = new ArrayList<>(mapaCadenas.values());
        Collections.sort(valores);
        return valores.get(valores.size() - 1);
    }

    public Collection<String> getLlaves() {
        List<String> llavesMayusculas = new ArrayList<>();
        for (String llave : mapaCadenas.keySet()) {
            llavesMayusculas.add(llave.toUpperCase());
        }
        return llavesMayusculas;
    }

    public int getCantidadCadenasDiferentes() {
        Set<String> valoresUnicos = new HashSet<>(mapaCadenas.values());
        return valoresUnicos.size();
    }

    public void agregarCadena(String cadena) {
        String llave = new StringBuilder(cadena).reverse().toString();
        mapaCadenas.put(llave, cadena);
    }

    public void eliminarCadenaConLLave(String llave) {
        mapaCadenas.remove(llave);
    }

    public void eliminarCadenaConValor(String valor) {
        String llave = null;
        for (Map.Entry<String, String> entry : mapaCadenas.entrySet()) {
            if (entry.getValue().equals(valor)) {
                llave = entry.getKey();
                break;
            }
        }
        if (llave != null) {
            mapaCadenas.remove(llave);
        }
    }

    public void reiniciarMapaCadenas(List<Object> objetos) {
        mapaCadenas.clear();
        for (Object objeto : objetos) {
            mapaCadenas.put(objeto.toString(), objeto.toString());
        }
    }

    public void volverMayusculas() {
        Map<String, String> nuevoMapa = new HashMap<>();
        for (Map.Entry<String, String> entry : mapaCadenas.entrySet()) {
            String llaveMayuscula = entry.getKey().toUpperCase();
            nuevoMapa.put(llaveMayuscula, entry.getValue());
        }
        mapaCadenas = nuevoMapa;
    }

    public boolean compararValores(String[] otroArreglo) {
        Set<String> valoresMapa = new HashSet<>(mapaCadenas.values());
        Set<String> valoresArreglo = new HashSet<>(Arrays.asList(otroArreglo));
        return valoresMapa.containsAll(valoresArreglo);
    }
}
