package org.openscience.cdk.libio.md;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openscience.cdk.Molecule;
import org.openscience.cdk.interfaces.IAtomContainer;

public class MDMolecule extends Molecule{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3129626782945020908L;

	//List of Residues
   	private List residues;

   	//List of ChargeGroups
   	private List chargeGroups;
	
	public MDMolecule() {
		super();
	}

	public MDMolecule(IAtomContainer container) {
		super(container);
	}

	public List getResidues() {
		return residues;
	}

	public void setResidues(List residues) {
		this.residues = residues;
	}

	/**
	 * Add a Residue to the MDMolecule if not already present
	 * @param residue Residue to add
	 */
	public void addResidue(Residue residue){
		if (residues==null) residues=new ArrayList();

		//Check if exists
		if (residues.contains(residue)){
			System.out.println("Residue: " + residue.getName() + " already present in molecule: " + getID());
			return;
		}
		
		residues.add(residue);
	}

	
	public List getChargeGroups() {
		return chargeGroups;
	}

	public void setChargeGroups(List chargeGroups) {
		this.chargeGroups = chargeGroups;
	}

	/**
	 * Add a ChargeGroup to the MDMolecule if not already present
	 * @param residue Residue to add
	 */
	public void addChargeGroup(ChargeGroup chargeGroup){
		if (chargeGroups==null) chargeGroups=new ArrayList();

		//Check if exists
		if (chargeGroups.contains(chargeGroup)){
			System.out.println("Charge group: " + chargeGroup.getNumber() + " already present in molecule: " + getID());
			return;
		}
		
		chargeGroups.add(chargeGroup);
	}
	
}
