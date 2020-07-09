package com.lyq.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jack
 */
@Getter
@Setter
public class IdEntity extends Entity {

    private static final long serialVersionUID = -1497135320122633518L;

    private Long id;

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((null == this.getId() ? 0 : this.getId().hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if (null == obj) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IdEntity other = (IdEntity) obj;
        if (null == this.getId()) {
            if (null != other.getId()) {
                return false;
            }
        } else if (!this.getId().equals(other.getId())) {
            return false;
        }
        return true;
    }

}
