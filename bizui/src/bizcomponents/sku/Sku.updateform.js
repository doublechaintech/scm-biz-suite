import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover, Switch } from 'antd'
import moment from 'moment'
import { connect } from 'dva'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import {ImageComponent} from '../../axios/tools'

import FooterToolbar from '../../components/FooterToolbar'

import styles from './Sku.updateform.less'
import SkuBase from './Sku.base'
<<<<<<< HEAD
=======
import appLocaleName from '../../common/Locale.tool'
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input

const imageURLPrefix = '//localhost:2090'

const imageKeys = [
  'picture',
]


class SkuUpdateForm extends Component {
  state = {
    previewVisible: false,
    previewImage: '',
    convertedImagesValues: {},
  }

  componentWillMount() {
    const selectedRow = this.getSelectedRow()
    if (!selectedRow) {
      return
    }
    this.setState({
      convertedImagesValues: mapFromImageValues(selectedRow,imageKeys)
    })
  }

  componentDidMount() {

  }

  shouldComponentUpdate() {
    return true
  }

  getSelectedRow() {
    // const { form, dispatch, submitting, selectedRows, currentUpdateIndex } = this.props
    const { selectedRows, currentUpdateIndex } = this.props
    if (!selectedRows) {
      return
    }
    if (currentUpdateIndex >= selectedRows.length) {
      return
    }
    const convertiedValues = selectedRows.map((item) => {
      return {
        ...item,

      }
    })
    const selectedRow = convertiedValues[currentUpdateIndex]
    return selectedRow
  }

  handleChange = (event, source) => {
    console.log('get file list from change in update change: ', source)
    const { fileList } = event
    const { convertedImagesValues } = this.state
    convertedImagesValues[source] = fileList
    this.setState({ convertedImagesValues })
    console.log('/get file list from change in update change: ', source)
  }


  handlePreview = (file) => {
    console.log('preview file', file)
    this.setState({
      previewImage: file.url || file.thumbUrl,
      previewVisible: true,
    })
  }

  render() {
    const { form, dispatch, submitting, selectedRows, currentUpdateIndex } = this.props
    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form
    const { convertedImagesValues } = this.state
    const { setFieldsValue } = this.props.form
<<<<<<< HEAD
=======
    const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    const {fieldLabels} = SkuBase
    const capFirstChar = (value)=>{
    	//const upper = value.replace(/^\w/, c => c.toUpperCase());
  		const upper = value.charAt(0).toUpperCase() + value.substr(1);
  		return upper
  	}
    const submitUpdateForm = () => {
      validateFieldsAndScroll((error, values) => {
        if (error) {
          console.log('code go here', error)
          return
        }
<<<<<<< HEAD

=======
		
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
        const { owner, role } = this.props
        const skuId = values.id
        const imagesValues = mapBackToImageValues(convertedImagesValues)
        const parameters = { ...values, skuId, ...imagesValues }

        
        const cappedRoleName = capFirstChar(role)
        dispatch({
          type: `${owner.type}/update${cappedRoleName}`,
          payload: {
            id: owner.id,
            role: role,
            parameters,
            selectedRows,
            currentUpdateIndex: 0,
            continueNext: false,
          },
        })
      })
    }
    
    const submitUpdateFormAndContinue = () => {
      validateFieldsAndScroll((error, values) => {
        if (error) {
          console.log('code go here', error)
          return
        }

        const { owner } = this.props
        const skuId = values.id
        const imagesValues = mapBackToImageValues(convertedImagesValues)
        const parameters = { ...values, skuId, ...imagesValues }

        // TODO
        const { currentUpdateIndex } = this.props
        
        if (currentUpdateIndex >= selectedRows.length - 1) {
          return
        }
        this.setState({
          currentUpdateIndex: currentUpdateIndex + 1,
        })
        //setFieldsValue(selectedRows[currentUpdateIndex + 1])
        const newIndex = currentUpdateIndex + 1
        dispatch({
          type: `${owner.type}/updateSku`,
          payload: {
            id: owner.id,
            type: 'sku',
            parameters,
            selectedRows,
            currentUpdateIndex: newIndex,
            continueNext: true,
          },
        })
      })
    }
    
    const skipToNext = () => {
      const { currentUpdateIndex } = this.props
      const { owner } = this.props
        
      const newIndex = currentUpdateIndex + 1
      dispatch({
        type: `${owner.type}/gotoNextSkuUpdateRow`,
        payload: {
          id: owner.id,
          type: 'sku',
          selectedRows,
          currentUpdateIndex: newIndex,
          continueNext: true,
          update: false,
        },
      })
    }
    
    const goback = () => {
      const { owner } = this.props
      dispatch({
        type: `${owner.type}/goback`,
        payload: {
          id: owner.id,
          type: 'sku',
<<<<<<< HEAD
          listName:'SKU列表' 
=======
          listName:appLocaleName(userContext,"List") 
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
        },
      })
    }
    const errors = getFieldsError()
    const getErrorInfo = () => {
      const errorCount = Object.keys(errors).filter(key => errors[key]).length
      if (!errors || errorCount === 0) {
        return null
      }
      const scrollToField = (fieldKey) => {
        const labelNode = document.querySelector(`label[for='${fieldKey}']`)
        if (labelNode) {
          labelNode.scrollIntoView(true)
        }
      }
      const errorList = Object.keys(errors).map((key) => {
        if (!errors[key]) {
          return null
        }
        return (
          <li key={key} className={styles.errorListItem} onClick={() => scrollToField(key)}>
            <Icon type="cross-circle-o" className={styles.errorIcon} />
            <div className={styles.errorMessage}>{errors[key][0]}</div>
            <div className={styles.errorField}>{fieldLabels[key]}</div>
          </li>
        )
      })
      return (
        <span className={styles.errorIcon}>
          <Popover
<<<<<<< HEAD
            title="表单校验信息"
=======
            title={appLocaleName(userContext,"FieldValidateInfo")}
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
            content={errorList}
            overlayClassName={styles.errorPopover}
            trigger="click"
            getPopupContainer={trigger => trigger.parentNode}
          >
            <Icon type="exclamation-circle" />
          </Popover>
          {errorCount}
        </span>
      )
    }
    
    if (!selectedRows) {
<<<<<<< HEAD
      return (<div>缺少被更新的对象</div>)
=======
      return (<div>{appLocaleName(userContext,"NoTargetItems")}</div>)
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    }
	const selectedRow = this.getSelectedRow()

	const formItemLayout = {
<<<<<<< HEAD
      labelCol: { span: 10 },
      wrapperCol: { span: 14 },
    }
    const switchFormItemLayout = {
      labelCol: { span: 14 },
      wrapperCol: { span: 4 },
    }

    return (
      <PageHeaderLayout
        title={"更新SKU"+(currentUpdateIndex+1)+"/"+selectedRows.length}
        content="更新SKU"
        wrapperClassName={styles.advancedForm}
      >
        <Card title="基础信息" className={styles.card} bordered={false}>
=======
      labelCol: { span: 6 },
      wrapperCol: { span: 12 },
    }
    const switchFormItemLayout = {
      labelCol: { span: 6 },
      wrapperCol: { span: 12 },
    }
	
	const internalRenderTitle = () =>{
      const linkComp=<a onClick={goback}  > <Icon type="double-left" style={{marginRight:"10px"}} /> </a>
      return (<div>{linkComp}{appLocaleName(userContext,"Update")}SKU: {(currentUpdateIndex+1)}/{selectedRows.length}</div>)
    }

	return (
      <PageHeaderLayout
        title={internalRenderTitle()}
        content={`${appLocaleName(userContext,"Update")}${(currentUpdateIndex+1)}/${selectedRows.length}`}
        wrapperClassName={styles.advancedForm}
      >
        <Card title={appLocaleName(userContext,"BasicInfo")} className={styles.card} bordered={false}>
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
          <Form >
            <Row gutter={16}>
            

<<<<<<< HEAD
              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.id} {...formItemLayout}>
                  {getFieldDecorator('id', {
                    initialValue: selectedRow.id,
                    rules: [{ required: true, message: '请输入序号' }],
                  })(
                    <Input placeholder="请输入序号" disabled/>
=======
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.id} {...formItemLayout}>
                  {getFieldDecorator('id', {
                    initialValue: selectedRow.id,
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="序号" disabled/>
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                    
                  )}
                </Form.Item>
              </Col>

<<<<<<< HEAD
              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.name} {...formItemLayout}>
                  {getFieldDecorator('name', {
                    initialValue: selectedRow.name,
                    rules: [{ required: true, message: '请输入名称' }],
                  })(
                    <Input placeholder="请输入名称" />
=======
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.name} {...formItemLayout}>
                  {getFieldDecorator('name', {
                    initialValue: selectedRow.name,
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="名称" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                    
                  )}
                </Form.Item>
              </Col>

<<<<<<< HEAD
              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.size} {...formItemLayout}>
                  {getFieldDecorator('size', {
                    initialValue: selectedRow.size,
                    rules: [{ required: true, message: '请输入大小' }],
                  })(
                    <Input placeholder="请输入大小" />
=======
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.size} {...formItemLayout}>
                  {getFieldDecorator('size', {
                    initialValue: selectedRow.size,
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="大小" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                    
                  )}
                </Form.Item>
              </Col>

<<<<<<< HEAD
              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.barcode} {...formItemLayout}>
                  {getFieldDecorator('barcode', {
                    initialValue: selectedRow.barcode,
                    rules: [{ required: true, message: '请输入条码' }],
                  })(
                    <Input placeholder="请输入条码" />
=======
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.barcode} {...formItemLayout}>
                  {getFieldDecorator('barcode', {
                    initialValue: selectedRow.barcode,
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="条码" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                    
                  )}
                </Form.Item>
              </Col>

<<<<<<< HEAD
              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.packageType} {...formItemLayout}>
                  {getFieldDecorator('packageType', {
                    initialValue: selectedRow.packageType,
                    rules: [{ required: true, message: '请输入包装类型' }],
                  })(
                    <Input placeholder="请输入包装类型" />
=======
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.packageType} {...formItemLayout}>
                  {getFieldDecorator('packageType', {
                    initialValue: selectedRow.packageType,
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="包装类型" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                    
                  )}
                </Form.Item>
              </Col>

<<<<<<< HEAD
              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.netContent} {...formItemLayout}>
                  {getFieldDecorator('netContent', {
                    initialValue: selectedRow.netContent,
                    rules: [{ required: true, message: '请输入净含量' }],
                  })(
                    <Input placeholder="请输入净含量" />
=======
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.netContent} {...formItemLayout}>
                  {getFieldDecorator('netContent', {
                    initialValue: selectedRow.netContent,
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="净含量" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                    
                  )}
                </Form.Item>
              </Col>

<<<<<<< HEAD
              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.price} {...formItemLayout}>
                  {getFieldDecorator('price', {
                    initialValue: selectedRow.price,
                    rules: [{ required: true, message: '请输入价格' }],
                  })(
                    <Input placeholder="请输入价格" />
=======
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.price} {...formItemLayout}>
                  {getFieldDecorator('price', {
                    initialValue: selectedRow.price,
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" prefix={`${appLocaleName(userContext,"Currency")}`} placeholder="价格" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                    
                  )}
                </Form.Item>
              </Col>

<<<<<<< HEAD
            </Row>
          </Form>  
        </Card>
=======
            
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
       
        
        
        


<<<<<<< HEAD
        <Card title={<div>附件 <Popover title="扫描二维码可以从手机上传图片或者附件" content={<div><img src='./qrtest.png'/></div>}><Icon type="qrcode" ></Icon></Popover></div>} className={styles.card} bordered={false}>
=======
			</Row>
          </Form>
        </Card>







        <Card title={<div>{appLocaleName(userContext,"Attachment")} <Popover title={appLocaleName(userContext,"ScanQRCodetoUploadfromSmartPhone")} content={<div><img src='./qrtest.png'/></div>}><Icon type="qrcode" ></Icon></Popover></div>} className={styles.card} bordered={false}>
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
          <Form >
            <Row gutter={16}>

              <Col lg={6} md={12} sm={24}>
                <ImageComponent
                  buttonTitle="图片"
                  handlePreview={this.handlePreview}
                  handleChange={event => this.handleChange(event, 'picture')}
                  fileList={convertedImagesValues.picture}
                />
              </Col>

            </Row>
          </Form>
        </Card>

        <FooterToolbar>
          {getErrorInfo()}
          <Button type="primary" onClick={submitUpdateForm} loading={submitting} htmlType="submit">
<<<<<<< HEAD
            更新
          </Button>
          <Button type="primary" onClick={submitUpdateFormAndContinue} loading={submitting} disabled={currentUpdateIndex + 1 >= selectedRows.length}>
            更新并装载下一个
          </Button>
          <Button type="default" onClick={skipToNext} loading={submitting} disabled={currentUpdateIndex + 1 >= selectedRows.length}>
            略过
          </Button>
          <Button type="default" onClick={goback} loading={submitting}>
            取消
=======
            {appLocaleName(userContext,"Update")}
          </Button>
          <Button type="primary" onClick={submitUpdateFormAndContinue} loading={submitting} disabled={currentUpdateIndex + 1 >= selectedRows.length}>
            {appLocaleName(userContext,"UpdateAndContinue")}
          </Button>
          <Button type="default" onClick={skipToNext} loading={submitting} disabled={currentUpdateIndex + 1 >= selectedRows.length}>
            {appLocaleName(userContext,"Skip")}
          </Button>
          <Button type="default" onClick={goback} loading={submitting}>
            {appLocaleName(userContext,"Cancel")}
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
          </Button>
        </FooterToolbar>
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(SkuUpdateForm))



