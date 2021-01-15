package com.waiwing.Shop.api.v1;

import com.waiwing.Shop.bo.PageCounter;
import com.waiwing.Shop.model.Spu;
import com.waiwing.Shop.exception.http.NotFoundException;
import com.waiwing.Shop.service.Spu.SpuService;
import com.waiwing.Shop.util.CommonUtil;
import com.waiwing.Shop.vo.PagingDozer;
import com.waiwing.Shop.vo.SpuSimplifyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/Spu")
@Validated //开启验证
public class SpuController {
    @Autowired
    private SpuService spuService;


    @GetMapping("/id/{id}/detail")
    public Spu getDetail(@PathVariable @Positive Long id) {
        Spu spu = spuService.getSpu(id);
        if (spu == null) {
            throw new NotFoundException(30003);
        }
        return spu;
    }

    @GetMapping("/latest")
    public PagingDozer<Spu, SpuSimplifyVO> getLatestSpuList(
            @RequestParam(defaultValue = "0") Integer start,
            @RequestParam(defaultValue = "10") Integer count
    ) {
        PageCounter pageCounter = CommonUtil.convertToPageParameter(start, count);
        Page<Spu> pageSpu = spuService.getLatestPagingSpu(pageCounter.getPage(), pageCounter.getCount());

        return new PagingDozer<Spu, SpuSimplifyVO>(pageSpu, SpuSimplifyVO.class);
//        List<SpuSimplifyVo> voList = new LinkedList<>();
//        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
//        pageSpu.forEach(spu -> voList.add(mapper.map(spu, SpuSimplifyVo.class)));
//        return voList;
    }

    @GetMapping("/by/category/{id}")
    public PagingDozer<Spu, SpuSimplifyVO> getByCategoryId(
            @PathVariable @Positive(message = "{id.positive}") Long id,
            @RequestParam(name = "is_root",defaultValue = "false") Boolean isRoot,
            @RequestParam(defaultValue = "0") Integer start,
            @RequestParam(defaultValue = "10") Integer count
    ) {
        PageCounter pageCounter = CommonUtil.convertToPageParameter(start, count);
        Page<Spu> pageSpu = spuService.getByCategory(id, isRoot, pageCounter.getPage(), pageCounter.getCount());
        return new PagingDozer<Spu, SpuSimplifyVO>(pageSpu, SpuSimplifyVO.class);
    }


}
