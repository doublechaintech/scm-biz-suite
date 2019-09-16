import React from 'react'
import { Icon,Divider } from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


const menuData = {menuName:"货架库存盘点", menuFor: "goodsShelfStockCount",
  		subItems: [
  {name: 'stockCountIssueTrackList', displayName:'库存计数问题跟踪', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName:"货架库存盘点", menuFor: "goodsShelfStockCount",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  title: '头衔',
  countTime: '计数时间',
  summary: '概览',
  shelf: '架',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'goodsShelfStockCount') , sorter: true },
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.countTime, dataIndex: 'countTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.summary, debugtype: 'string', dataIndex: 'summary', width: '22',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.shelf, dataIndex: 'shelf', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(goodsShelfStockCount,targetComponent)=>{

  const userContext = null
  return (
    <div key={goodsShelfStockCount.id}>
	
      <DescriptionList  key={goodsShelfStockCount.id} size="small" col="4">
        <Description term="序号">{goodsShelfStockCount.id}</Description> 
        <Description term="头衔">{goodsShelfStockCount.title}</Description> 
        <Description term="计数时间"><div>{ moment(goodsShelfStockCount.countTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term="概览">{goodsShelfStockCount.summary}</Description> 
        <Description term="架"><div>{goodsShelfStockCount.shelf==null?appLocaleName(userContext,"NotAssigned"):`${goodsShelfStockCount.shelf.displayName}(${goodsShelfStockCount.shelf.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const GoodsShelfStockCountBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default GoodsShelfStockCountBase



