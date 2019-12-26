import React from 'react'
<<<<<<< HEAD
import { Icon,Divider } from 'antd'
=======
import { Icon,Divider, Avata, Card, Col} from 'antd'
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
<<<<<<< HEAD
=======

>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
<<<<<<< HEAD
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
=======
	defaultRenderAvatarCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
	defaultSearchLocalData,
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
<<<<<<< HEAD
=======
const renderAvatarCell=defaultRenderAvatarCell
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


<<<<<<< HEAD
const menuData = {menuName:"货架", menuFor: "goodsShelf",
  		subItems: [
  {name: 'goodsShelfStockCountList', displayName:'货架库存盘点', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'goodsAllocationList', displayName:'货位', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('goods_shelf'), menuFor: "goodsShelf",
  		subItems: [
  {name: 'goodsShelfStockCountList', displayName: window.mtrans('goods_shelf_stock_count','goods_shelf.goods_shelf_stock_count_list',false), type:'goodsShelfStockCount',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'goodsAllocationList', displayName: window.mtrans('goods_allocation','goods_shelf.goods_allocation_list',false), type:'goodsAllocation',icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD
=======

const settingMenuData = {menuName: window.trans('goods_shelf'), menuFor: "goodsShelf",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('goods_shelf.id'),
  location: window.trans('goods_shelf.location'),
  storageSpace: window.trans('goods_shelf.storage_space'),
  supplierSpace: window.trans('goods_shelf.supplier_space'),
  damageSpace: window.trans('goods_shelf.damage_space'),
  lastUpdateTime: window.trans('goods_shelf.last_update_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'goodsShelf') , sorter: true },
  { title: fieldLabels.location, debugtype: 'string', dataIndex: 'location', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.storageSpace, dataIndex: 'storageSpace', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.supplierSpace, dataIndex: 'supplierSpace', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.damageSpace, dataIndex: 'damageSpace', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(goodsShelf,targetComponent)=>{

  const userContext = null
  return (
    <div key={goodsShelf.id}>
	
      <DescriptionList  key={goodsShelf.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{goodsShelf.id}</Description> 
        <Description term={fieldLabels.location} style={{wordBreak: 'break-all'}}>{goodsShelf.location}</Description> 
        <Description term={fieldLabels.storageSpace}><div>{goodsShelf.storageSpace==null?appLocaleName(userContext,"NotAssigned"):`${goodsShelf.storageSpace.displayName}(${goodsShelf.storageSpace.id})`}
        </div></Description>
        <Description term={fieldLabels.supplierSpace}><div>{goodsShelf.supplierSpace==null?appLocaleName(userContext,"NotAssigned"):`${goodsShelf.supplierSpace.displayName}(${goodsShelf.supplierSpace.id})`}
        </div></Description>
        <Description term={fieldLabels.damageSpace}><div>{goodsShelf.damageSpace==null?appLocaleName(userContext,"NotAssigned"):`${goodsShelf.damageSpace.displayName}(${goodsShelf.damageSpace.id})`}
        </div></Description>
        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(goodsShelf.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"货架", menuFor: "goodsShelf",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  location: '位置',
  storageSpace: '存货区',
  supplierSpace: '供应商的空间',
  damageSpace: '残次货物存放区',
  lastUpdateTime: '最后更新时间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'goodsShelf') , sorter: true },
  { title: fieldLabels.location, debugtype: 'string', dataIndex: 'location', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.storageSpace, dataIndex: 'storageSpace', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.supplierSpace, dataIndex: 'supplierSpace', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.damageSpace, dataIndex: 'damageSpace', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(goodsShelf,targetComponent)=>{

  const userContext = null
  return (
    <div key={goodsShelf.id}>
	
      <DescriptionList  key={goodsShelf.id} size="small" col="4">
        <Description term="序号">{goodsShelf.id}</Description> 
        <Description term="位置">{goodsShelf.location}</Description> 
        <Description term="存货区"><div>{goodsShelf.storageSpace==null?appLocaleName(userContext,"NotAssigned"):`${goodsShelf.storageSpace.displayName}(${goodsShelf.storageSpace.id})`}
        </div></Description>
        <Description term="供应商的空间"><div>{goodsShelf.supplierSpace==null?appLocaleName(userContext,"NotAssigned"):`${goodsShelf.supplierSpace.displayName}(${goodsShelf.supplierSpace.id})`}
        </div></Description>
        <Description term="残次货物存放区"><div>{goodsShelf.damageSpace==null?appLocaleName(userContext,"NotAssigned"):`${goodsShelf.damageSpace.displayName}(${goodsShelf.damageSpace.id})`}
        </div></Description>
        <Description term="最后更新时间"><div>{ moment(goodsShelf.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {location, storageSpaceId, supplierSpaceId, damageSpaceId} = formValuesToPack
	const storageSpace = {id: storageSpaceId, version: 2^31}
	const supplierSpace = {id: supplierSpaceId, version: 2^31}
	const damageSpace = {id: damageSpaceId, version: 2^31}
	const data = {location, storageSpace, supplierSpace, damageSpace}
	return data
}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {location, storageSpaceId, supplierSpaceId, damageSpaceId} = formValuesToPack
	const storageSpace = {id: storageSpaceId, version: 2^31}
	const supplierSpace = {id: supplierSpaceId, version: 2^31}
	const damageSpace = {id: damageSpaceId, version: 2^31}
	const data = {location, storageSpace, supplierSpace, damageSpace}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {location, storageSpace, supplierSpace, damageSpace} = objectToUnpack
	const storageSpaceId = storageSpace ? storageSpace.id : null
	const supplierSpaceId = supplierSpace ? supplierSpace.id : null
	const damageSpaceId = damageSpace ? damageSpace.id : null
	const data = {location, storageSpaceId, supplierSpaceId, damageSpaceId}
	return data
}
<<<<<<< HEAD

const GoodsShelfBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
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
const GoodsShelfBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default GoodsShelfBase



