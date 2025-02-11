/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * (C) Copyright 2009-2023, Arnaud Roques
 *
 * Project Info:  http://plantuml.com
 * 
 * If you like this project or if you find it useful, you can support us at:
 * 
 * http://plantuml.com/patreon (only 1$ per month!)
 * http://plantuml.com/paypal
 * 
 * This file is part of PlantUML.
 *
 * PlantUML is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PlantUML distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public
 * License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 *
 * Original Author:  Arnaud Roques
 * 
 *
 */
package net.sourceforge.plantuml.cucadiagram;

import java.util.Objects;

import net.sourceforge.plantuml.StringUtils;
import net.sourceforge.plantuml.baraye.EntityFactory;

public class CodeImpl implements Code {

	private final String name;

	private CodeImpl(String name) {
		this.name = Objects.requireNonNull(name);
	}

	public static Code of(String code) {
		if (code == null)
			EntityFactory.bigError();

		return new CodeImpl(code);
	}

	public final String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		final CodeImpl other = (CodeImpl) obj;
		return this.name.equals(other.name);
	}

	public Code eventuallyRemoveStartingAndEndingDoubleQuote(String format) {
		return CodeImpl.of(StringUtils.eventuallyRemoveStartingAndEndingDoubleQuote(getName(), format));
	}

}
