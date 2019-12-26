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
const menuData = {menuName:"会员收藏产品", menuFor: "memberWishlistProduct",
=======

const menuData = {menuName: window.trans('member_wishlist_product'), menuFor: "memberWishlistProduct",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

<<<<<<< HEAD

const settingMenuData = {menuName:"会员收藏产品", menuFor: "memberWishlistProduct",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  name: '名称',
  owner: '业主',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'memberWishlistProduct') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(memberWishlistProduct,targetComponent)=>{

  const userContext = null
  return (
    <div key={memberWishlistProduct.id}>
	
      <DescriptionList  key={memberWishlistProduct.id} size="small" col="4">
        <Description term="序号">{memberWishlistProduct.id}</Description> 
        <Description term="名称">{memberWishlistProduct.name}</Description> 
        <Description term="业主"><div>{memberWishlistProduct.owner==null?appLocaleName(userContext,"NotAssigned"):`${memberWishlistProduct.owner.displayName}(${memberWishlistProduct.owner.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, ownerId} = formValuesToPack
	const owner = {id: ownerId, version: 2^31}
	const data = {name, owner}
	return data
}
=======

const settingMenuData = {menuName: window.trans('member_wishlist_product'), menuFor: "memberWishlistProduct",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('member_wishlist_product.id'),
  name: window.trans('member_wishlist_product.name'),
  owner: window.trans('member_wishlist_product.owner'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'memberWishlistProduct') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(memberWishlistProduct,targetComponent)=>{

  const userContext = null
  return (
    <div key={memberWishlistProduct.id}>
	
      <DescriptionList  key={memberWishlistProduct.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{memberWishlistProduct.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{memberWishlistProduct.name}</Description> 
        <Description term={fieldLabels.owner}><div>{memberWishlistProduct.owner==null?appLocaleName(userContext,"NotAssigned"):`${memberWishlistProduct.owner.displayName}(${memberWishlistProduct.owner.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, ownerId} = formValuesToPack
	const owner = {id: ownerId, version: 2^31}
	const data = {name, owner}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, owner} = objectToUnpack
	const ownerId = owner ? owner.id : null
	const data = {name, ownerId}
	return data
}
<<<<<<< HEAD

const MemberWishlistProductBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const MemberWishlistProductBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default MemberWishlistProductBase



