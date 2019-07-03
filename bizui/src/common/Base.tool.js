
import React from 'react'
import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../components/ImagePreview'
import appLocaleName from './Locale.tool'

const defaultRenderTextCell=(value, record)=>{
	const userContext = null
	if(!value){
		return '';
	}
	if(value==null){
		return '';
	}
	if(value.length>15){
       
        return `${value.substring(0,15)}...(${value.length})${appLocaleName(userContext,"Chars")}`
        
	}
	return value
	
}

const defaultRenderIdentifier=(value, record, targtObjectType)=>{

	return (<Link to={`/${targtObjectType}/${value}/dashboard`}>{value}</Link>)
	
}

const defaultRenderDateCell=(value, record)=>{
	return moment(value).format('YYYY-MM-DD');
}
const defaultRenderDateTimeCell=(value, record)=>{
	return moment(value).format('YYYY-MM-DD HH:mm');	
}

const defaultRenderImageCell=(value, record, title)=>{
	return (<ImagePreview imageTitle={title} imageLocation={value} />)	
}


const defaultFormatMoney=(amount)=>{
	const options={style: 'decimal',minimumFractionDigits: 2,maximumFractionDigits:2}
    const moneyFormat = new Intl.NumberFormat('en-US',options);
	return moneyFormat.format(amount)
	
}

const defaultRenderMoneyCell=(value, record)=>{
	const userContext = null
	if(!value){
		return appLocaleName(userContext,"Empty")
	}
	if(value == null){
		return appLocaleName(userContext,"Empty")
	}
	return (`${appLocaleName(userContext,"Currency")}${defaultFormatMoney(value)}`)
}

const defaultRenderBooleanCell=(value, record)=>{
	const userContext = null

	return  (value? appLocaleName(userContext,"Yes") : appLocaleName(userContext,"No"))

}

const defaultRenderReferenceCell=(value, record)=>{
	const userContext = null
	return (value ? <span style={{fontWeight:"bold"}} title={`${value.id} - ${value.displayName}`} >{value.displayName}</span> : appLocaleName(userContext,"NotAssigned")) 

}


const BaseTool = {
    defaultRenderReferenceCell,
    defaultRenderBooleanCell,
    defaultRenderMoneyCell,
    defaultFormatMoney,
    defaultRenderDateTimeCell,
    defaultRenderImageCell,
    defaultRenderDateCell,
    defaultRenderIdentifier,
    defaultRenderTextCell,
   
  };
  
  export default BaseTool;
  