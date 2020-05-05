
import React from 'react'
import { Link } from 'dva/router'
import { Icon, Divider, Avatar, Card, Col,Tag} from 'antd'


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
// import { Avatar, Icon } from 'antd';
const defaultRenderIdentifier=(value, record, targtObjectType)=>{

	return (<Link to={`/${targtObjectType}/${value}/dashboard`}>{value}</Link>)
	
}

const defaultRenderDateCell=(value, record)=>{
	return moment(value).format('YYYY-MM-DD');
}
const defaultRenderDateTimeCell=(value, record)=>{
	return moment(value).format('YYYY-MM-DD HH:mm');	
}

const defaultRenderAvatarCell=(value, record, title)=>{
	return (<Avatar src={value} />)	
}

const defaultRenderImageCell=(value, record, title)=>{
	return (<ImagePreview imageTitle={title} imageLocation={value} />)	
}


const defaultFormatMoney=(amount)=>{
	const options={style: 'decimal',minimumFractionDigits: 2,maximumFractionDigits:2}
    const moneyFormat = new Intl.NumberFormat('en-US',options);
	return moneyFormat.format(amount)
	
}

const defaultFormatNumber=(amount)=>{

	return amount
	
}

const defaultRenderNumberCell=(value, record)=>{
	const userContext = null
	if(!value){
		return appLocaleName(userContext,"Empty")
	}
	if(value == null){
		return appLocaleName(userContext,"Empty")
	}
	return (`${defaultFormatNumber(value)}`)
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
	return (value ? <Tag color='green'><span style={{fontWeight:"bold"}} title={`${value.id} - ${value.displayName}`} >{value.displayName}</span></Tag> : appLocaleName(userContext,"NotAssigned")) 

}




const buildFunctionTitle=(menuData,searchTerm)=>{


	const result = menuData.subItems.filter(item=>item.name.indexOf(searchTerm)>=0||item.displayName.indexOf(searchTerm)>=0)

	if(!result || result.length===0){
		return null
	}

	return <Col span={4} style={{fontWeight:'bold'}}>{menuData.menuName}功能</Col>

}
const buildFunctionList=(menuData,targetObject,searchTerm)=>{


	const result = menuData.subItems.filter(item=>item.name.indexOf(searchTerm)>=0||item.displayName.indexOf(searchTerm)>=0)

	if(!result || result.length===0){
		return null
	}

	return <Col span={20}>{result.map(item=>(

		<Col span={4}><Link to={`/${menuData.menuFor}/${targetObject.id}/list/${item.name}/${item.displayName}`}>{item.displayName}</Link></Col>
	))}</Col>
	
}


const buildCategoryTitle=(item)=>{

	return <Col span={4} style={{fontWeight:'bold'}}> {`${item.displayName}(${item.filteredData.length})`}</Col>

}
const buildCategoryContent=(item)=>{

	let maxLength = 0;
	item.filteredData.forEach(fi => {
		const {length} = fi.displayName;
		if(length> maxLength) {
			maxLength = length;
		}
	});

	// every 2 chars use a span

	
	
	let spanCount = 4
	if(maxLength > 10){
		spanCount = 8
	}
	if(maxLength > 20){
		spanCount = 12
	}

	return <Col span={20}>
		 {item.filteredData.map(fi=>(<Col span={spanCount}><Link to={`/${item.type}/${fi.id}/dashboard`}>{fi.displayName}</Link></Col>))}
		</Col>

}

const matchSearchTerm=(innerItem, searchTerm)=>{

	if(!innerItem){
		return false
	}
	if(!innerItem.displayName){
		return false
	}
	if(!innerItem.id){
		return false
	}
	if(innerItem.displayName.indexOf(searchTerm)>=0){
		return true;
	}
	if(innerItem.id.indexOf(searchTerm)>=0){
		return true;
	}
	return false

}
const defaultSearchLocalData=(menuData, targetObject, searchName)=>{

	console.log("targetObject", targetObject)
	if(!targetObject){
		return null
	}
	const wrappedData=menuData.subItems.map(item=>({...item, data: targetObject[item.name]}))
	const resultData=wrappedData.map(item=>{
		const {data}=item
		if(!data){
			return {...item,filteredData:[]}
		}
		const filteredData = data.filter(innerItem=>matchSearchTerm(innerItem,searchName))
		return {...item,filteredData}
		
	})
	const filteredResult = resultData.filter(item=>item.filteredData&&item.filteredData.length>0)
	// precisely matched the record, just go to this page
	if(searchName&&filteredResult&&filteredResult.length===1&&filteredResult[0].filteredData.length===1&&searchName.trim().length !== 0){
		const item = filteredResult[0]
		const fi = filteredResult[0].filteredData[0];
		window.location=`#/${item.type}/${fi.id}/dashboard`
		return
	}



	console.log("filteredResult", filteredResult)
	const result = menuData.subItems.filter(item=>item.name.indexOf(searchName)>=0||item.displayName.indexOf(searchName)>=0)

	return (<div >{
		result&&result.length>0&&(<Card  key={"__function"} >
			{buildFunctionTitle(menuData,searchName)}{buildFunctionList(menuData,targetObject,searchName)}
			</Card>)
		}
		
		{filteredResult.map(item=>(

			<Card  key={item.displayName} >
				{buildCategoryTitle(item)}{buildCategoryContent(item)}
			</Card>)
		)}
	  </div>)
	
	

}



const subList=(listData,searchValue)=>{

	if(!searchValue){
		return listData
	}
    return listData.filter(item=>item.name.indexOf(searchValue)>=0)
  }
const allTreeLeafKeys=(listData)=>{
    return listData.map(item=>item.id)
}

const hasTreeNodes=(listData)=>{
    return listData.filter(item=>item.valuesOfGroupBy&&item.valuesOfGroupBy.length>0).length>0
}

// 兼容TreeSelect/Tree/Cascader

const genTree=(listData, searchValue)=>{
    
    const parentNodes = [];
    const rootTree = {children:[]}
    subList(listData,searchValue)
      .map(item=>{

        const {valuesOfGroupBy} = item
        const child = {title:item.name,key:item.id,value:item.id,label:item.name}
        const {length} = valuesOfGroupBy
        if(valuesOfGroupBy && length === 0){
          // no parent node, the child it self is the root 
          rootTree.children.push(child)
          return
        }
        const itemParentNodes = []
        itemParentNodes.push(rootTree)
        // enrich all ancestors
        valuesOfGroupBy.forEach((groupItem,index)=>
          {
            const key = `${groupItem}-${index}`
            const itemParentNode = parentNodes[key]
            if(!itemParentNode){
              // if there are no node registered, then add it
              const newRootItem={title:groupItem,key,value:key,label:groupItem,level:index,children:[]}
              parentNodes[key] = newRootItem
              itemParentNodes.push(newRootItem)
              return
            }
            // found! then push to parent nodes
            itemParentNodes.push(itemParentNode)

          }
        )
        itemParentNodes.push(child)

       
        // connect to all the ancestors
        itemParentNodes.forEach((node,index)=>{

          if(index>0){
            const prev = itemParentNodes[index-1]
            const current = itemParentNodes[index]
            if(prev.children.filter(childItem=>childItem.key===current.key).length===0){
              prev.children.push(current)
            }
          }
        })
        return {...item, itemParentNodes}
        // ensure parent nodes
        
           
    })
    
    return rootTree.children
    
    
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
	defaultRenderAvatarCell,
	defaultSearchLocalData,
	defaultRenderNumberCell,
	allTreeLeafKeys,genTree,hasTreeNodes,
   
  };
  
  export default BaseTool;
  