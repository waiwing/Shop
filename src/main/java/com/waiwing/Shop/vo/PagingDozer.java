package com.waiwing.Shop.vo;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class PagingDozer<T, K> extends Paging {
    @SuppressWarnings("unchecked")
    public PagingDozer(Page<T> pageT,Class<K> classK) {
        this.initPageParamters(pageT);

        List<T> tList = pageT.getContent();
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        List<K> voList = new ArrayList<K>();
        tList.forEach(t->{
            K vo = mapper.map(t,classK);
            voList.add(vo);
        });
        this.setItems(voList);
    }
}
