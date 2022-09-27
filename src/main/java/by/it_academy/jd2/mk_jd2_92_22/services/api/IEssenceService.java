package by.it_academy.jd2.mk_jd2_92_22.services.api;

import java.util.List;

public interface IEssenceService<TYPE> {

    List<TYPE> get();

    TYPE get(int id);



    void validate(TYPE item);
}
