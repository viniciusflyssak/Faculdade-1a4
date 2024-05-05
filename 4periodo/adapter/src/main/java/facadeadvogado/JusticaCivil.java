/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facadeadvogado;

/**
 *
 * @author vinic
 */
public class JusticaCivil implements IJustica{
    public Processo getProcesso(){
        ProcessoCivil processo =  new ProcessoCivil();
        return processo;
    }
}
