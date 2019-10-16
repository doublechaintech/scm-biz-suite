import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover, Switch } from 'antd'
import moment from 'moment'
import { connect } from 'dva'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import {ImageComponent} from '../../axios/tools'

import FooterToolbar from '../../components/FooterToolbar'

import styles from './ObjectAccess.updateform.less'
import ObjectAccessBase from './ObjectAccess.base'
<<<<<<< HEAD
=======
import appLocaleName from '../../common/Locale.tool'
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input

const imageURLPrefix = '//localhost:2090'

const imageKeys = [
]


class ObjectAccessUpdateForm extends Component {
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
    const {fieldLabels} = ObjectAccessBase
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
        const objectAccessId = values.id
        const imagesValues = mapBackToImageValues(convertedImagesValues)
        const parameters = { ...values, objectAccessId, ...imagesValues }

        
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
        const objectAccessId = values.id
        const imagesValues = mapBackToImageValues(convertedImagesValues)
        const parameters = { ...values, objectAccessId, ...imagesValues }

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
          type: `${owner.type}/updateObjectAccess`,
          payload: {
            id: owner.id,
            type: 'objectAccess',
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
        type: `${owner.type}/gotoNextObjectAccessUpdateRow`,
        payload: {
          id: owner.id,
          type: 'objectAccess',
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
          type: 'objectAccess',
<<<<<<< HEAD
          listName:'对象访问列表' 
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
        title={"更新对象访问"+(currentUpdateIndex+1)+"/"+selectedRows.length}
        content="更新对象访问"
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
      return (<div>{linkComp}{appLocaleName(userContext,"Update")}对象访问: {(currentUpdateIndex+1)}/{selectedRows.length}</div>)
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
                    <Input size="large" placeholder="ID" disabled/>
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
                <Form.Item label={fieldLabels.objectType} {...formItemLayout}>
                  {getFieldDecorator('objectType', {
                    initialValue: selectedRow.objectType,
                    rules: [{ required: true, message: '请输入对象类型' }],
                  })(
                    <Input placeholder="请输入对象类型" />
=======
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.objectType} {...formItemLayout}>
                  {getFieldDecorator('objectType', {
                    initialValue: selectedRow.objectType,
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="访问对象类型" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                    
                  )}
                </Form.Item>
              </Col>

<<<<<<< HEAD
              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.list1} {...formItemLayout}>
                  {getFieldDecorator('list1', {
                    initialValue: selectedRow.list1,
                    rules: [{ required: true, message: '请输入表' }],
                  })(
                    <Input placeholder="请输入表" />
=======
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.list1} {...formItemLayout}>
                  {getFieldDecorator('list1', {
                    initialValue: selectedRow.list1,
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="列表1" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                    
                  )}
                </Form.Item>
              </Col>

<<<<<<< HEAD
              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.list2} {...formItemLayout}>
                  {getFieldDecorator('list2', {
                    initialValue: selectedRow.list2,
                    rules: [{ required: true, message: '请输入清单' }],
                  })(
                    <Input placeholder="请输入清单" />
=======
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.list2} {...formItemLayout}>
                  {getFieldDecorator('list2', {
                    initialValue: selectedRow.list2,
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="列表2" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                    
                  )}
                </Form.Item>
              </Col>

<<<<<<< HEAD
              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.list3} {...formItemLayout}>
                  {getFieldDecorator('list3', {
                    initialValue: selectedRow.list3,
                    rules: [{ required: true, message: '请输入目录3' }],
                  })(
                    <Input placeholder="请输入目录3" />
=======
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.list3} {...formItemLayout}>
                  {getFieldDecorator('list3', {
                    initialValue: selectedRow.list3,
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="列表3" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                    
                  )}
                </Form.Item>
              </Col>

<<<<<<< HEAD
              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.list4} {...formItemLayout}>
                  {getFieldDecorator('list4', {
                    initialValue: selectedRow.list4,
                    rules: [{ required: true, message: '请输入清单' }],
                  })(
                    <Input placeholder="请输入清单" />
=======
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.list4} {...formItemLayout}>
                  {getFieldDecorator('list4', {
                    initialValue: selectedRow.list4,
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="列表4" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                    
                  )}
                </Form.Item>
              </Col>

<<<<<<< HEAD
              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.list5} {...formItemLayout}>
                  {getFieldDecorator('list5', {
                    initialValue: selectedRow.list5,
                    rules: [{ required: true, message: '请输入列表6' }],
                  })(
                    <Input placeholder="请输入列表6" />
=======
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.list5} {...formItemLayout}>
                  {getFieldDecorator('list5', {
                    initialValue: selectedRow.list5,
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="列表5" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                    
                  )}
                </Form.Item>
              </Col>

<<<<<<< HEAD
              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.list6} {...formItemLayout}>
                  {getFieldDecorator('list6', {
                    initialValue: selectedRow.list6,
                    rules: [{ required: true, message: '请输入list6' }],
                  })(
                    <Input placeholder="请输入list6" />
=======
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.list6} {...formItemLayout}>
                  {getFieldDecorator('list6', {
                    initialValue: selectedRow.list6,
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="列表6" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                    
                  )}
                </Form.Item>
              </Col>

<<<<<<< HEAD
              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.list7} {...formItemLayout}>
                  {getFieldDecorator('list7', {
                    initialValue: selectedRow.list7,
                    rules: [{ required: true, message: '请输入list7' }],
                  })(
                    <Input placeholder="请输入list7" />
=======
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.list7} {...formItemLayout}>
                  {getFieldDecorator('list7', {
                    initialValue: selectedRow.list7,
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="列表7" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                    
                  )}
                </Form.Item>
              </Col>

<<<<<<< HEAD
              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.list8} {...formItemLayout}>
                  {getFieldDecorator('list8', {
                    initialValue: selectedRow.list8,
                    rules: [{ required: true, message: '请输入list8' }],
                  })(
                    <Input placeholder="请输入list8" />
=======
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.list8} {...formItemLayout}>
                  {getFieldDecorator('list8', {
                    initialValue: selectedRow.list8,
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="列表8" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                    
                  )}
                </Form.Item>
              </Col>

<<<<<<< HEAD
              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.list9} {...formItemLayout}>
                  {getFieldDecorator('list9', {
                    initialValue: selectedRow.list9,
                    rules: [{ required: true, message: '请输入list9' }],
                  })(
                    <Input placeholder="请输入list9" />
=======
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.list9} {...formItemLayout}>
                  {getFieldDecorator('list9', {
                    initialValue: selectedRow.list9,
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="列表9" />
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
        <FooterToolbar>
          {getErrorInfo()}
          <Button type="primary" onClick={submitUpdateForm} loading={submitting} htmlType="submit">
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
			</Row>
          </Form>
        </Card>







        <FooterToolbar>
          {getErrorInfo()}
          <Button type="primary" onClick={submitUpdateForm} loading={submitting} htmlType="submit">
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
}))(Form.create()(ObjectAccessUpdateForm))



