package com.wdg.jvm;

import com.wdg.common.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * User: wangdaogang
 * Date: 2019/9/10
 * Description: No Description
 */
public class OOMTest {
    static String params = "{\"rawData\":{\"US Style\":\"310714151004\",\"备注\":\"女士服装\",\"Mfg\":\"466651\",\"品类\":\"毛衣/针织衫\",\"商品Label\":\"POLO RALPH LAUREN\",\"pm_operation\":\"ralphlauren\",\"色号\":\"D86\",\"原标题\":\"丝绒连帽衫与慢跑裤套装\",\"BATCH\":\"20190902115352\",\"原翻译\":\"这款可人的连帽衫与慢跑裤套装选用柔软的丝绒，胸前左侧设计有标志性小马标，是彰显傲人风格的不二之选。<ul><li>棉、聚酯纤维。</li><li>可机洗。</li><li>9 个月婴儿尺码衣长 31.1 厘米，袖长 36.8 厘米。袖长从后领的中心位置量起。</li><li>9 个月婴儿尺码长裤裆长 18.4 厘米，内接缝长 22.2 厘米。</li><li>连帽衫：标志性刺绣小马位于胸前左侧；同种面料衬里风帽；长袖，罗纹袖口；分离式袋鼠口袋；罗纹下摆。</li><li>长裤：弹性裤腰，预系结蝴蝶结；罗纹裤脚口。</li><li>进口。</li></ul>\",\"barcode\":[{\"颜色\":\"灰色\",\"平台对接编码\":\"WMPOSWENN810020D86XS\",\"尺码排序合并\":\"女装XS\",\"尺码\":\"XS\",\"barcode_id\":\"WMPOSWENN810020D86XS\",\"Colors计数\":\"1\",\"排序\":\"2\",\"吊牌价(系统推送）\":\"990\",\"pm_operation\":\"ralphlauren\",\"色号\":\"D86\",\"男女童细分类目\":\"女装\",\"AX计数\":\"1\",\"AX\":\"WMPOSWENN810020\",\"AX+Color\":\"WMPOSWENN810020D86\",\"Division\":\"WM\",\"色码\":\"D86-灰色\",\"spuState_tmall_ralphlauren\":\"未在售\",\"skuState_tmall_ralphlauren\":\"平台未发布\",\"编码\":\"RL20667\"},{\"颜色\":\"灰色\",\"平台对接编码\":\"WMPOSWENN810020D86S\",\"尺码排序合并\":\"女装S\",\"尺码\":\"S\",\"barcode_id\":\"WMPOSWENN810020D86S\",\"Colors计数\":\" \",\"排序\":\"3\",\"吊牌价(系统推送）\":\"990\",\"pm_operation\":\"ralphlauren\",\"色号\":\"D86\",\"男女童细分类目\":\"女装\",\"AX计数\":\" \",\"AX\":\"WMPOSWENN810020\",\"AX+Color\":\"WMPOSWENN810020D86\",\"Division\":\"WM\",\"色码\":\"D86-灰色\",\"spuState_tmall_ralphlauren\":\"未在售\",\"skuState_tmall_ralphlauren\":\"平台未发布\",\"编码\":\"RL20667\"},{\"颜色\":\"灰色\",\"平台对接编码\":\"WMPOSWENN810020D86M\",\"尺码排序合并\":\"女装M\",\"尺码\":\"M\",\"barcode_id\":\"WMPOSWENN810020D86M\",\"Colors计数\":\" \",\"排序\":\"4\",\"吊牌价(系统推送）\":\"990\",\"pm_operation\":\"ralphlauren\",\"色号\":\"D86\",\"男女童细分类目\":\"女装\",\"AX计数\":\" \",\"AX\":\"WMPOSWENN810020\",\"AX+Color\":\"WMPOSWENN810020D86\",\"Division\":\"WM\",\"色码\":\"D86-灰色\",\"spuState_tmall_ralphlauren\":\"未在售\",\"skuState_tmall_ralphlauren\":\"平台未发布\",\"编码\":\"RL20667\"},{\"颜色\":\"灰色\",\"平台对接编码\":\"WMPOSWENN810020D86L\",\"尺码排序合并\":\"女装L\",\"尺码\":\"L\",\"barcode_id\":\"WMPOSWENN810020D86L\",\"Colors计数\":\" \",\"排序\":\"5\",\"吊牌价(系统推送）\":\"990\",\"pm_operation\":\"ralphlauren\",\"色号\":\"D86\",\"男女童细分类目\":\"女装\",\"AX计数\":\" \",\"AX\":\"WMPOSWENN810020\",\"AX+Color\":\"WMPOSWENN810020D86\",\"Division\":\"WM\",\"色码\":\"D86-灰色\",\"spuState_tmall_ralphlauren\":\"未在售\",\"skuState_tmall_ralphlauren\":\"平台未发布\",\"编码\":\"RL20667\"}],\"男/女/童装\":\"女婴 0-24个月\",\"主色\":\"B10\",\"修改短标题\":\"短袖毛衣\",\"商品标题\":\"POLO RALPH LAUREN\",\"编码\":\"RL20667\",\"create_time\":\"2019-09-02 11:53:52\",\"REFID\":\"1319136\",\"库存\":\"\",\"修改文案\":\"宽松版型和短袖设计增加了这款柔软的棉混毛衫的实用性<ul><li>宽松版型。长及臀部</li><li>\u200B美国 M 号尺码衣长 55.2 厘米，胸围 45.1 厘米，肩宽 36.2 厘米</li><li>圆领</li><li>\u200B短袖，罗纹袖口</li><li>罗纹下摆</li><li>模特身高 178 厘米，穿美国 S 号尺码</li></ul>\",\"季节\":\"2019年秋季\",\"上新情况\":\"补色\",\"第八位\":\"F\",\"细分类目\":\"女装\",\"AX\":\"WMPOSWENN810020\",\"面料成分\":\"81%棉16%锦纶3%氨纶装饰品除外\",\"Lable\":\"CW\",\"AX+Color\":\"WMPOSWENN810020D86\",\"超级季节\":\"\",\"Class\":\"\",\"_id\":\"5d6c92506a0d770015d05bf3\",\"行号\":2,\"吊牌价\":\"990\",\"周期\":\"Y20-W22\",\"uniqueId\":\"CWPO2STF8510065D53\",\"京东发布类目\":\"服饰内衣>>女装>>针织衫\"},\"operation\":\"ralphlauren\",\"ruleLevelCondition\":{\"1\":\"ralphlauren\",\"2\":\"JD\"},\"useCase\":1}";
    public static void main(String[] args) {
        //oomTest();
        stackOverFlowTest();
    }

    static void oomTest(){
        List<Result> list = new ArrayList<>();
        while (true){
            list.add(new Result());
        }
    }
    static void stackOverFlowTest(){

        while (true){
            System.out.println(params.intern());;
        }
    }
}
