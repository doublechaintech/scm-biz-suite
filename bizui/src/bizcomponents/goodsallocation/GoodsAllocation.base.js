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


const menuData = {menuName:"货位", menuFor: "goodsAllocation",
  		subItems: [
  {name: 'goodsList', displayName:'货物', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName:"货位", menuFor: "goodsAllocation",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  location: '位置',
  latitude: '纬度',
  longitude: '经度',
  goodsShelf: '货架',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'goodsAllocation') , sorter: true },
  { title: fieldLabels.location, debugtype: 'string', dataIndex: 'location', width: '25',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.latitude, debugtype: 'double', dataIndex: 'latitude', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.longitude, debugtype: 'double', dataIndex: 'longitude', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.goodsShelf, dataIndex: 'goodsShelf', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(goodsAllocation,targetComponent)=>{

  const userContext = null
  return (
    <div key={goodsAllocation.id}>
	
      <DescriptionList  key={goodsAllocation.id} size="small" col="4">
        <Description term="序号">{goodsAllocation.id}</Description> 
        <Description term="位置">{goodsAllocation.location}</Description> 
        <Description term="纬度"><div style={{"color":"red"}}>{goodsAllocation.latitude}</div></Description> 
        <Description term="经度"><div style={{"color":"red"}}>{goodsAllocation.longitude}</div></Description> 
        <Description term="货架"><div>{goodsAllocation.goodsShelf==null?appLocaleName(userContext,"NotAssigned"):`${goodsAllocation.goodsShelf.displayName}(${goodsAllocation.goodsShelf.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const GoodsAllocationBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default GoodsAllocationBase



