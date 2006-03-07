/* $RCSfile$
 * $Author$
 * $Date$
 * $Revision$
 *
 * Copyright (C) 2005  The Chemistry Development Kit (CDK) project
 *
 * Contact: cdk-devel@lists.sourceforge.net
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package org.openscience.cdk.applications.undoredo;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.vecmath.Point2d;

import org.openscience.cdk.interfaces.IAtom;
import org.openscience.cdk.interfaces.IAtomContainer;

public class MoveAtomEdit extends AbstractUndoableEdit {

	private IAtomContainer undoRedoContainer;

	private int deltaX;
	
	private int deltaY;

	public MoveAtomEdit(IAtomContainer undoRedoContainer, int deltaX, int deltaY) {
		this.undoRedoContainer = undoRedoContainer;
		this.deltaX=deltaX;
		this.deltaY=deltaY;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.undo.UndoableEdit#redo()
	 */
	public void redo() throws CannotRedoException {
		for (int i = 0; i < undoRedoContainer.getAtomCount(); i++) {
			IAtom atom=undoRedoContainer.getAtomAt(i);
			Point2d newPoint = new Point2d(atom.getX2d() + deltaX, atom.getY2d() + deltaY);
			atom.setPoint2d(newPoint);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.undo.UndoableEdit#undo()
	 */
	public void undo() throws CannotUndoException {
		for (int i = 0; i < undoRedoContainer.getAtomCount(); i++) {
			IAtom atom=undoRedoContainer.getAtomAt(i);
			Point2d newPoint = new Point2d(atom.getX2d() - deltaX, atom.getY2d() - deltaY);
			atom.setPoint2d(newPoint);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.undo.UndoableEdit#canRedo()
	 */
	public boolean canRedo() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.undo.UndoableEdit#canUndo()
	 */
	public boolean canUndo() {
		return true;
	}

}
