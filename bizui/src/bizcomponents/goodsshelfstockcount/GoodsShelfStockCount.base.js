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
const menuData = {menuName:"货架库存盘点", menuFor: "goodsShelfStockCount",
  		subItems: [
  {name: 'stockCountIssueTrackList', displayName:'库存计数问题跟踪', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('goods_shelf_stock_count'), menuFor: "goodsShelfStockCount",
  		subItems: [
  {name: 'stockCountIssueTrackList', displayName: window.mtrans('stock_count_issue_track','goods_shelf_stock_count.stock_count_issue_track_list',false), type:'stockCountIssueTrack',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD
=======

const settingMenuData = {menuName: window.trans('goods_shelf_stock_count'), menuFor: "goodsShelfStockCount",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('goods_shelf_stock_count.id'),
  title: window.trans('goods_shelf_stock_count.title'),
  countTime: window.trans('goods_shelf_stock_count.count_time'),
  summary: window.trans('goods_shelf_stock_count.summary'),
  shelf: window.trans('goods_shelf_stock_count.shelf'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'goodsShelfStockCount') , sorter: true },
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.countTime, dataIndex: 'countTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.summary, debugtype: 'string', dataIndex: 'summary', width: '22',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.shelf, dataIndex: 'shelf', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(goodsShelfStockCount,targetComponent)=>{

  const userContext = null
  return (
    <div key={goodsShelfStockCount.id}>
	
      <DescriptionList  key={goodsShelfStockCount.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{goodsShelfStockCount.id}</Description> 
        <Description term={fieldLabels.title} style={{wordBreak: 'break-all'}}>{goodsShelfStockCount.title}</Description> 
        <Description term={fieldLabels.countTime}><div>{ moment(goodsShelfStockCount.countTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.summary} style={{wordBreak: 'break-all'}}>{goodsShelfStockCount.summary}</Description> 
        <Description term={fieldLabels.shelf}><div>{goodsShelfStockCount.shelf==null?appLocaleName(userContext,"NotAssigned"):`${goodsShelfStockCount.shelf.displayName}(${goodsShelfStockCount.shelf.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"货架库存盘点", menuFor: "goodsShelfStockCount",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

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
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {title, countTime, summary, shelfId} = formValuesToPack
	const shelf = {id: shelfId, version: 2^31}
	const data = {title, countTime, summary, shelf}
	return data
}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {title, countTime, summary, shelfId} = formValuesToPack
	const shelf = {id: shelfId, version: 2^31}
	const data = {title, countTime, summary, shelf}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {title, countTime, summary, shelf} = objectToUnpack
	const shelfId = shelf ? shelf.id : null
	const data = {title, countTime, summary, shelfId}
	return data
}
<<<<<<< HEAD

const GoodsShelfStockCountBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const GoodsShelfStockCountBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default GoodsShelfStockCountBase



