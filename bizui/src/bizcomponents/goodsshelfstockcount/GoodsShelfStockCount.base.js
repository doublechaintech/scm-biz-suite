<<<<<<< HEAD

import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'


=======
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
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854


const menuData = {menuName:"货架库存盘点", menuFor: "goodsShelfStockCount",
  		subItems: [
<<<<<<< HEAD
  {name: 'stockCountIssueTrackList', displayName:'库存计数问题跟踪', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
=======
  {name: 'stockCountIssueTrackList', displayName:'库存计数问题跟踪', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  
  		],
}

<<<<<<< HEAD
const renderTextCell=(value, record)=>{

	if(!value){
		return '';
	}
	if(value==null){
		return '';
	}
	if(value.length>15){
		return value.substring(0,15)+"...("+value.length+"字)"
	}
	return value
	
}

const renderIdentifier=(value, record, targtObjectType)=>{

	return (<Link to={`/${targtObjectType}/${value}/dashboard`}>{value}</Link>)
	
}

const renderDateCell=(value, record)=>{
	return moment(value).format('YYYY-MM-DD');
}
const renderDateTimeCell=(value, record)=>{
	return moment(value).format('YYYY-MM-DD HH:mm');	
}

const renderImageCell=(value, record, title)=>{
	return (<ImagePreview imageTitle={title} imageLocation={value} />)	
}

const renderMoneyCell=(value, record)=>{
	if(!value){
		return '空'
	}
	if(value == null){
		return '空'
	}
	return (`￥${value.toFixed(2)}`)
}

const renderBooleanCell=(value, record)=>{

	return  (value? '是' : '否')

}

const renderReferenceCell=(value, record)=>{

	return (value ? value.displayName : '暂无') 
=======

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
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

}

const displayColumns = [
<<<<<<< HEAD
  { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'goodsShelfStockCount') },
  { title: '头衔', debugtype: 'string', dataIndex: 'title', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: '计数时间', dataIndex: 'countTime', render: (text, record) =>renderDateCell(text,record) },
  { title: '概览', debugtype: 'string', dataIndex: 'summary', width: '22',render: (text, record)=>renderTextCell(text,record) },
  { title: '架', dataIndex: 'shelf', render: (text, record) => renderReferenceCell(text, record)},

]

const fieldLabels = {
  id: '序号',
  title: '头衔',
  countTime: '计数时间',
  summary: '概览',
  shelf: '架',

}


const GoodsShelfStockCountBase={menuData,displayColumns,fieldLabels,displayColumns}
=======
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
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
export default GoodsShelfStockCountBase



