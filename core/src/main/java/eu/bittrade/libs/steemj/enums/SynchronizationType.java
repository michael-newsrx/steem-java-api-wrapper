/*
 *     This file is part of SteemJ (formerly known as 'Steem-Java-Api-Wrapper')
 * 
 *     SteemJ is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *     SteemJ is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 * 
 *     You should have received a copy of the GNU General Public License
 *     along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */
package eu.bittrade.libs.steemj.enums;

/**
 * An enumeration for all existing synchronization types.
 * 
 * @author <a href="http://steemit.com/@dez1337">dez1337</a>
 */
public enum SynchronizationType {
    /** Synchronize everything. */
    FULL,
    /** Only synchronize available APIs. */
    APIS_ONLY,
    /** Only synchronize properties. */
    PROPERTIES_ONLY,
    /** Do not synchronize values with the connected Node. */
    NONE
}
