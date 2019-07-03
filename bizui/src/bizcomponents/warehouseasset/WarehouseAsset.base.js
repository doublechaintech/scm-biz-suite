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


const menuData = {menuName:"仓库资产", menuFor: "warehouseAsset",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  name: '名称',
  position: '位置',
  owner: '业主',
  lastUpdateTime: '最后更新时间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.position, debugtype: 'string', dataIndex: 'position', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(warehouseAsset,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={warehouseAsset.id}>
	
	<DescriptionList  key={warehouseAsset.id} size="small" col="4">
<Description term="序号">{warehouseAsset.id}</Description> 
<Description term="名称">{warehouseAsset.name}</Description> 
<Description term="位置">{warehouseAsset.position}</Description> 
<Description term="业主">{warehouseAsset.owner==null?appLocaleName(userContext,"NotAssigned"):`${warehouseAsset.owner.displayName}(${warehouseAsset.owner.id})`}
</Description>
<Description term="最后更新时间">{ moment(warehouseAsset.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const WarehouseAssetBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default WarehouseAssetBase



