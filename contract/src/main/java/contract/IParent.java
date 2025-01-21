/**
 * 
 */
package contract;

import java.util.List;

import model.Parent;

/**
 * 
 */
public interface IParent {
    void addParent(Parent parent);
    Parent getParentById(int parentId);
    List<Parent> getAllParents();
    void updateParent(Parent parent);
    void archiveParent(int parentId);
}
