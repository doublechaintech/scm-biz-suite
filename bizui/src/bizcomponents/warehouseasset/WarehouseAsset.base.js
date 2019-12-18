import React from 'react'
import { Icon,Divider, Avata, Card, Col} from 'antd'

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
	defaultRenderAvatarCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
	defaultSearchLocalData,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderAvatarCell=defaultRenderAvatarCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell



const menuData = {menuName: window.trans('warehouse_asset'), menuFor: "warehouseAsset",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('warehouse_asset'), menuFor: "warehouseAsset",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('warehouse_asset.id'),
  name: window.trans('warehouse_asset.name'),
  position: window.trans('warehouse_asset.position'),
  owner: window.trans('warehouse_asset.owner'),
  lastUpdateTime: window.trans('warehouse_asset.last_update_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'warehouseAsset') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.position, debugtype: 'string', dataIndex: 'position', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(warehouseAsset,targetComponent)=>{

  const userContext = null
  return (
    <div key={warehouseAsset.id}>
	
      <DescriptionList  key={warehouseAsset.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{warehouseAsset.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{warehouseAsset.name}</Description> 
        <Description term={fieldLabels.position} style={{wordBreak: 'break-all'}}>{warehouseAsset.position}</Description> 
        <Description term={fieldLabels.owner}><div>{warehouseAsset.owner==null?appLocaleName(userContext,"NotAssigned"):`${warehouseAsset.owner.displayName}(${warehouseAsset.owner.id})`}
        </div></Description>
        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(warehouseAsset.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, position, ownerId} = formValuesToPack
	const owner = {id: ownerId, version: 2^31}
	const data = {name, position, owner}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, position, owner} = objectToUnpack
	const ownerId = owner ? owner.id : null
	const data = {name, position, ownerId}
	return data
}
const stepOf=(targetComponent, title, content, position, index)=>{
	return {
		title,
		content,
		position,
		packFunction: packFormValuesToObject,
		unpackFunction: unpackObjectToFormValues,
		index,
      }
}
const WarehouseAssetBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default WarehouseAssetBase



